package com.ait.gym;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
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
		if (member != null) {
			if (member.getPassword().equals(this.password) && member.getUserName().equals(this.userName)) {
				message = "member";
			}
		}

		return message;
	}

	private Member getMemberbyUserName(String username) {
		MembersList memberList = Helper.getBean("membersList", MembersList.class);
		return memberList.getMemberByUserName(userName);
	}

	public String logout() {
		Helper.expungeSession();
		return "index.xhtml?faces-redirect=true";
	}

}
