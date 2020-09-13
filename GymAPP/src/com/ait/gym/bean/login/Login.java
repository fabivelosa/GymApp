package com.ait.gym.bean.login;

import java.io.Serializable;

<<<<<<< HEAD:GymAPP/src/com/ait/gym/bean/login/Login.java

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

=======
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
>>>>>>> f27f7ad0b3c310306c223a950eb2bed84d0a0a9a:GymAPP/src/com/ait/gym/bean/Login.java
import javax.servlet.http.HttpSession;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.Member;
import com.ait.gym.bean.lists.EmployeeList;
import com.ait.gym.bean.lists.MembersList;
import com.ait.gym.utils.Helper;

@ManagedBean
<<<<<<< HEAD:GymAPP/src/com/ait/gym/bean/login/Login.java
@SessionScoped
public class Login extends LoginSetup implements Serializable {
=======
@RequestScoped
public class Login implements Serializable {
>>>>>>> f27f7ad0b3c310306c223a950eb2bed84d0a0a9a:GymAPP/src/com/ait/gym/bean/Login.java

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD:GymAPP/src/com/ait/gym/bean/login/Login.java
	
	

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
=======
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
>>>>>>> f27f7ad0b3c310306c223a950eb2bed84d0a0a9a:GymAPP/src/com/ait/gym/bean/Login.java
	}

	private boolean loginUser(Person user) {
		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);

<<<<<<< HEAD:GymAPP/src/com/ait/gym/bean/login/Login.java
		if (member != null) {
			if (member.getPassword().equals(this.getPassword()) && member.getUserName().equals(username)) {
				session.setAttribute("loggedUser", member);
=======
		if (user != null) {
			if (user.getPassword().equals(this.password) && user.getUserName().equals(this.userName)) {
				session.setAttribute("loggedUser", user);
>>>>>>> f27f7ad0b3c310306c223a950eb2bed84d0a0a9a:GymAPP/src/com/ait/gym/bean/Login.java
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

<<<<<<< HEAD:GymAPP/src/com/ait/gym/bean/login/Login.java
		if (emp != null) {
			if (emp.getPassword().equals(this.getPassword()) && emp.getEmailAddress().equals(this.getUserName())) {
				session.setAttribute("loggedUser", emp);
				session.setAttribute("isUserLogged", "true");
				session.setAttribute("userType", "E");
				return true;
			}
		}
		return false;
=======
		Person user = getMemberbyUserName(userName);

		if (user == null) {
			user = getEmployeebyUser(userName);
		} 
		return user;
>>>>>>> f27f7ad0b3c310306c223a950eb2bed84d0a0a9a:GymAPP/src/com/ait/gym/bean/Login.java
	}

	private Member getMemberbyUserName(String username) {
		MembersList memberList = Helper.getBean("membersList", MembersList.class);
<<<<<<< HEAD:GymAPP/src/com/ait/gym/bean/login/Login.java
		return memberList.getMemberByUserName(getUserName());
=======
		if (memberList != null) {
			return memberList.getMemberByUserName(userName);
		} else {
			return null;
		}

>>>>>>> f27f7ad0b3c310306c223a950eb2bed84d0a0a9a:GymAPP/src/com/ait/gym/bean/Login.java
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
<<<<<<< HEAD:GymAPP/src/com/ait/gym/bean/login/Login.java

=======
>>>>>>> f27f7ad0b3c310306c223a950eb2bed84d0a0a9a:GymAPP/src/com/ait/gym/bean/Login.java
}
