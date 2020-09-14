package com.ait.gym.bean.login;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.Member;
import com.ait.gym.bean.Person;
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

		Person user = getUserByUserName(getUserName());
		String returnedUser = isMemberHere(getUserName(), user);
		String returnedUser2 = isEmployeeHere(getUserName(), user);
		if (returnedUser.equals("member")) {

			message = "member";
		}
		if (returnedUser2.equals("trainershomepage")) {

			message = "trainershomepage";

		}

		return message;
	}

	public String isMemberHere(String username, Person user) {

		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

		user = getMemberbyUserName(username);

		String here = "";

		if (user != null) {
			if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equals(this.getPassword())) {

				session.setAttribute("loggedUser", user);
				session.setAttribute("isUserLogged", "true");
				session.setAttribute("userType", "E");
				here = "member";
			}
		}
		return here;
	}

	public String isEmployeeHere(String username, Person user) {

		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
		user = getEmployeebyUsername(username);
		String here = "";

		if (user != null) {
			if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equals(this.getPassword())) {

				session.setAttribute("loggedUser", user);
				session.setAttribute("isUserLogged", "true");
				session.setAttribute("userType", "M");
				here = "trainershomepage";
			}
		}
		return here;
	}

	private Person getUserByUserName(String userName) {

		Person user = new Person();
		user = getMemberbyUserName(userName);

		if (user == null) {
			user = getEmployeebyUsername(userName);
		}
		return user;
	}

	private Member getMemberbyUserName(String username) {
		MembersList memberList = Helper.getBean("membersList", MembersList.class);
		return memberList.getMemberByUserName(getUserName());
	}

	private Employee getEmployeebyUsername(String username) {
		EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);
		return employeeList.getEmployeeByUserName(username);
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
