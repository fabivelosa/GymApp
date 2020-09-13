package com.ait.gym.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ait.gym.bean.lists.EmployeeList;
import com.ait.gym.bean.lists.MembersList;
import com.ait.gym.utils.Helper;

@ManagedBean
@RequestScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String userName;

	public Login(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}

	public Login() {
	}

	@PostConstruct
	public void init() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("Password = " + password);
		this.password = password;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("User = " + userName);
		this.userName = userName;
	}

	public String loginYesNo() {
		String page = null;

		Person user = getUserByUserName(userName);

		if (user != null && loginUser(user)) {

			if (user.getId().contains("M")) {
				page = "member";
			} else {
				page = "trainershomepage";
			}
		} else {
			Helper.setInfoMessage("INFO!","Invalid User or Password!");
			page = "login.xhtml?faces-redirect=true";			
			
		}
		return page;
	}

	private boolean loginUser(Person user) {
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

		if (user != null) {
			if (user.getPassword().equals(this.password) && user.getUserName().equals(this.userName)) {
				session.setAttribute("loggedUser", user);
				session.setAttribute("isUserLogged", "true");
				if (user instanceof Member) {
					session.setAttribute("userType", "M");
				} else if (user instanceof Employee) {
					session.setAttribute("userType", "P");
				}
				return true;
			}
		}
		return false;
	}

	private Person getUserByUserName(String userName) {

		Person user = getMemberbyUserName(userName);

		if (user == null) {
			user = getEmployeebyUser(userName);
		} 
		return user;
	}

	private Member getMemberbyUserName(String username) {
		MembersList memberList = Helper.getBean("membersList", MembersList.class);
		if (memberList != null) {
			return memberList.getMemberByUserName(userName);
		} else {
			return null;
		}

	}

	private Employee getEmployeebyUser(String username) {
		EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);
		if (employeeList != null) {
			return employeeList.getEmployeeByUserName(username);
		} else {
			return null;
		}
	}

	public String logout() {

		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

		session.removeAttribute("loggedUser");
		session.removeAttribute("isUserLogged");
		session.removeAttribute("userType");
		System.out.println("logging out");
		return "index?faces-redirect=true";
	}
}
