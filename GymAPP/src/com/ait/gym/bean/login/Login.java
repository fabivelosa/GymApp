package com.ait.gym.bean.login;

import java.io.Serializable;
import java.util.ArrayList;


import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.Member;
import com.ait.gym.bean.lists.EmployeeList;
import com.ait.gym.bean.lists.MembersList;
import com.ait.gym.utils.Helper;

@ManagedBean
@SessionScoped
public class Login extends LoginSetup implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	

	public String loginYesNo() {
		String message = "index.xhtml?faces-redirect=true";
		
		if (this.getType().equalsIgnoreCase("M")) {
			if (loginMember(getUserName())) {
				message = "member";
			}

		} else {
			if (loginEmployee(getUserName())) {
				message = "trainershomepage";
			}
		}

		return message;
	}
	
	
/*	public String loginYesNo() {
		String message = "index.xhtml?faces-redirect=true";
		

		Member member = getMemberbyUserName(getUserName());
		Employee emp = getEmployeebyEmail(getUserName());
		String returnedUser = isMemberHere(getUserName(), member, emp);
			if (returnedUser.equals("member")) {
				
				message = "member";
			} 
			if (returnedUser.equals("trainershomepage")) {
				message = "trainershomepage";
			} 
		

		return message;
	}
	
*/
	
	public String isMemberHere(String username, Member member, Employee emp) {

		member = getMemberbyUserName(username);
		emp = getEmployeebyEmail(username);
		String here = "";
		
			if (member.getUserName().equalsIgnoreCase(username) && member.getPassword().equals(this.getPassword())) {
				
				 here = "member";
			} 
			
			if (emp.getEmailAddress().equalsIgnoreCase(username) && emp.getPassword().equals(this.getPassword())) {
				 here = "trainershomepage";
			}

		

		return here;
	}

	private boolean loginMember(String username) {
		Member member = getMemberbyUserName(username);
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

		if (member != null) {
			if (member.getPassword().equals(this.getPassword()) && member.getUserName().equals(username)) {
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
			if (emp.getPassword().equals(this.getPassword()) && emp.getEmailAddress().equals(this.getUserName())) {
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
		return memberList.getMemberByUserName(getUserName());
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

}
