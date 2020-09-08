package com.ait.gym.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

import com.ait.gym.bean.lists.EmployeeList;
import com.ait.gym.bean.lists.MembersList;
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
	
	@PostConstruct
	public void init() {
		
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

		System.out.println("Logout" + session.getAttribute(getUserName()));
		session.removeAttribute("loggedUser");
		session.setAttribute("isUserLogged", "false");
		session.removeAttribute("userType");
		System.out.println("logging out");
		
		
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

//			ArrayList<Member> member = null;
//			if (isMemberHere(userName, member)) {
//				message = "member";
//			}
//	
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

	public boolean isMemberHere(String username, ArrayList<Member> member) {

		for (int i = 0; i < member.size(); i++) {
			System.out.println();
			Member existingMember = member.get(i);
			if (existingMember.getUserName().equalsIgnoreCase(username)) {
				return true;
			}

		}

		return false;

	}

	private boolean loginMember(String username) {
		Member member = getMemberbyUserName(username);
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

		if (member != null) {
			if (member.getPassword().equals(this.password) && member.getUserName().equals(username)) {
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
		// ((HttpSession)
		// FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
		
		session.removeAttribute("loggedUser");
		session.removeAttribute("isUserLogged");
		session.removeAttribute("userType");
		System.out.println("logging out");
		return "index?faces-redirect=true";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
