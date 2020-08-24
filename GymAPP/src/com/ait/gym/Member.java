package com.ait.gym;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class Member {
	private String memberID;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String mobileNumber;
	private String emailAddress;
	private String address;
	private String city;
	private String goal;
	private Login login;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberID, String firstName, String lastName, Date dob, String mobileNumber,
			String emailAddress, String address, String city, String gender, String goal, String login,
			String password) {
		super();
		this.memberID = memberID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.city = city;
		this.gender = gender;
		this.goal = goal;
		Login userLogin = new Login(login, password);
		this.setLogin(userLogin);
	}

	public Member(String memberID) {
		super();
		this.memberID = memberID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Login getLogin() {

		if (login == null) {
			login = new Login();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	// Validate Email
	public void validateEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Email Address is Valid");
			throw new ValidatorException(message);
		}
	}

	// Action Methods
	public String storeMemberInfo() {
		boolean stored = true;
		FacesMessage message = null;
		String outcome = null;
		if (stored) {
			message = new FacesMessage("Gym Member created Successfully.");
			outcome = "success";
		} else {
			message = new FacesMessage("Gym Member Information is NOT stored Successfully.");
			outcome = "member";
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		return outcome;
	}

	public String addMemberHandler(Member member) {
		MembersList members = Helper.getBean("memberList", MembersList.class);
		members.addMemberList(member);
		return null;
	}

}
