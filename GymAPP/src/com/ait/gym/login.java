package com.ait.gym;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class login implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String userName;
	
	public login(String password, String userName) {
		super();
		this.password = password;
		this.userName = userName;
	}
	public login() {}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("Password = "+password);
		this.password = password;
	}
	public String getUserName() {
		
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("User = "+userName);
		this.userName = userName;
	}
	
	public String loginYesNo() {
		String adminPassword = "password";
		String AdminUser = "admin";
		if(password.equals(adminPassword)  && userName.equals(AdminUser)) {
			
			return "successfulLogin";
		}else		
		 return "login";
		
		
	}
	
	

}
