package com.ait.gym;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String userName;
	private Member members;

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
		
		Member member = getMemberbyUserName(userName);		
		String message = "index.xhtml?faces-redirect=true";
		if(member != null && member.getLogin() != null) {
			Login login = member.getLogin();
			if(login.getUserName() != null && login.getPassword() != null){
				if (login.getPassword().equals(this.password) && login.getUserName().equals(this.userName)) {
					message = "successfulLogin";
				}
			}
		}
		
		return message;
	}

	private Member getMemberbyUserName(String username) {

		return Helper.getBean("member", Member.class);

	}
	
	public String logout() {
		Helper.expungeSession();
		return "index.xhtml?faces-redirect=true";
	}

}


	