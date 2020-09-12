package com.ait.gym.bean.login;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LoginSetup {
	private String password;
	private String userName;
	private String type;

	public LoginSetup(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}

	public LoginSetup() {
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
