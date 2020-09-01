package com.ait.gym.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ait.gym.utils.Helper;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String userName;
	private String type;

	public Login(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}

	public Login() {
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
		String message = "index.xhtml?faces-redirect=true";

		if (this.getType().equalsIgnoreCase("M")) {
			if (loginMember(userName)) {
				message = "member";
			}

		} else {
			if (loginEmployee(userName)) {
				message = "trainershomepage";
			}

		}

		return message;
	}

	private boolean loginMember(String username) {
		Member member = getMemberbyUserName(userName);
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

		if (member != null) {
			if (member.getPassword().equals(this.password) && member.getUserName().equals(this.userName)) {
				session.setAttribute("loggedUser", member);
				session.setAttribute("isUserLogged", "true");
				session.setAttribute("userType", "M");
				return true;
			}
		}

		return false;

	}

	private boolean loginEmployee(String userName) {
		Employee emp = getEmployeebyEmail(userName);
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

		if (emp != null) {
			if (emp.getPassword().equals(this.password) && emp.getEmailAddress().equals(this.userName)) {
				session.setAttribute("loggedUser", emp);
				session.setAttribute("isUserLogged", "true");
				session.setAttribute("userType", "E");
				return true;
			}
		}

		return false;

	}

	private Member getMemberbyUserName(String username) {
		MembersList memberList = Helper.getBean("membersList", MembersList.class);
		return memberList.getMemberByUserName(userName);
	}

	private Employee getEmployeebyEmail(String email) {
		EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);
		return employeeList.getEmployeeByUserEmail(email);
	}

	public String logout() {
		// Helper.expungeSession();
		//((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
		
		session.setAttribute("loggedUser", null);
		session.setAttribute("isUserLogged", "false");
		session.setAttribute("userType", null);
		
		return "index";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
