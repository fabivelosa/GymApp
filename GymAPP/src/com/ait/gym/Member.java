package com.ait.gym;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class Member {
	private String memberID;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String mobileNumber;
	private String emailAddress;
	private String address;
	private String eircode;
	private String city;
	private String goal;
	private String userName;
	private String password;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String memberID, String firstName, String lastName, Date dob, String mobileNumber,
			String emailAddress, String address, String city,String eircode, String gender, String goal, String login,
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
		this.setEircode(eircode);
		this.setUserName(login);
		this.setPassword(password);
		
		
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
				
		addMemberHandler(this);
		FacesMessage message =  new FacesMessage("Gym Member created Successfully.");;
		String outcome = "success";		
		FacesContext.getCurrentInstance().addMessage(null, message);
		return outcome;
	}

	public void addMemberHandler(Member member) {	
		MembersList members = Helper.getBean("membersList", MembersList.class);		
		members.getMembers().add(member);
		System.out.println("members count -->"+members.getMembersCount());
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEircode() {
		return eircode;
	}

	public void setEircode(String eircode) {
		this.eircode = eircode;
	}

}


