package com.ait.gym.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.ait.gym.bean.lists.MembersList;
import com.ait.gym.utils.Helper;

@ManagedBean
@RequestScoped
public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private int oneToOneCredit;
	private List<GymClass> bookedClasses;
	private List<GymClass> oneToOneClasses;
	
	
	static int range = 1000; 
	
	@PostConstruct
	public void init() {
		oneToOneClasses= new ArrayList<GymClass>();
	
	}

	public Member() {
		super();
		Random random = new Random();    
		this.setMemberID("M" + random.nextInt(range));
		this.oneToOneCredit = 0;
	}
	
	public Member(String firstName,String login,String password) {
		super();
		this.firstName = firstName;
		this.setUserName(login);
		this.setPassword(password);
		Random random = new Random();    
		this.setMemberID("M" + random.nextInt(range));
		this.oneToOneCredit = 0;
		
	}

	public Member(String firstName, String lastName, Date dob, String mobileNumber, String emailAddress, String address,
			String city, String gender, String goal, String eircode, String login, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobileNumber = mobileNumber; 
		this.emailAddress = emailAddress;
		this.address = address;
		this.city = city;
		this.gender = gender;
		this.goal = goal;
		this.eircode = eircode;
		this.setUserName(login);
		this.setPassword(password);	
		Random random = new Random();    
		this.setMemberID("M" + random.nextInt(range));
		this.oneToOneCredit = 0;
	}

	public Member(String memberID) {
		super();
		this.setMemberID(memberID);
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

	private void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
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

	// Validate Email
	public void validateEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Email Address is Invalid");
			throw new ValidatorException(message); 
		}
	}

	// Validate User Already Exists
	public void validateUserName(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String username = (String) value;
		MembersList members = Helper.getBean("membersList", MembersList.class);
		Member member = members.getMemberByUserName(username);
		if (member != null && member.getUserName().equals(username)) {
			FacesMessage message = new FacesMessage("Username already exists!");
			throw new ValidatorException(message);
		}
	}

	// Action Methods
	public String  storeMemberInfo() {
		addMemberHandler(this);
		FacesMessage message = new FacesMessage("Account created Successfully.");
		String outcome = "login.xhtml?faces-redirect=true";
		FacesContext.getCurrentInstance().addMessage(null, message);
		
		//Helper.sendRedirect(outcome);
		return outcome;
		
	}

	public void addMemberHandler(Member member) {
		MembersList members = Helper.getBean("membersList", MembersList.class);
		members.getMembers().add(member);
		System.out.println("members count -->" + members.getMembersCount());
	}

	public int getOneToOneCredit() {
		return oneToOneCredit;
	}

	public void setOneToOneCredit(int oneToOneCredit) {
		this.oneToOneCredit = oneToOneCredit;
	}

	public List<GymClass> getOneToOneClasses() {
		return oneToOneClasses;
	}

	public void setOneToOneClasses(List<GymClass> oneToOneClasses) {
		this.oneToOneClasses = oneToOneClasses;
	}

	public List<GymClass> getBookedClasses() {
		return bookedClasses;
	}

	public void setBookedClasses(List<GymClass> bookedClasses) {
		this.bookedClasses = bookedClasses;
	}

}
