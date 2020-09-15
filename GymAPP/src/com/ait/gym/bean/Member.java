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
import com.ait.gym.interfaces.UserActions;
import com.ait.gym.utils.CreditTypes;
import com.ait.gym.utils.Helper;

@ManagedBean
@RequestScoped
public class Member extends Person implements Serializable, UserActions {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String goal;
	private int oneToOneCredit;
	private CreditTypes membershipType;
	private List<GymClass> bookedClasses;
	private List<GymClass> oneToOneClasses;
	private int totalBookedClasses;

	static int range = 1000;

	@PostConstruct
	public void init() {
		oneToOneClasses = new ArrayList<GymClass>();
		bookedClasses = new ArrayList<GymClass>();

	}

	public Member(String firstName, String login, String password) {
		super();
		this.setFirstName(firstName);
		this.setUserName(login);
		this.setPassword(password);
		Random random = new Random();
		this.setId("M" + random.nextInt(range));
		this.oneToOneCredit = 1;
		this.membershipType = CreditTypes.TREE_MONTHS;

	}

	public Member(String firstName, String lastName, Date dob, String mobileNumber, String emailAddress, String address,
			String city, String gender, String goal, String eircode, String login, String password,
			CreditTypes membershipType) {
		super();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDob(dob);
		this.setMobileNumber(mobileNumber);
		this.setEmailAddress(emailAddress);
		this.setAddress(address);
		this.setCity(city);
		this.setGender(gender);
		this.goal = goal;
		this.setEircode(eircode);
		this.setUserName(login);
		this.setPassword(password);
		Random random = new Random();
		this.setId("M" + random.nextInt(range));
		this.oneToOneCredit = 0;
		this.membershipType = membershipType;
	}

	public Member() {
		Random random = new Random();
		this.setId("M" + random.nextInt(range));

	}

	public Member(String memberID) {
		super();
		this.setId(memberID);
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
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

	@Override
	public String storeInfo() {
		addMemberHandler(this);
		Helper.setSessionAttribute("isUserNew", this);
		FacesMessage message = new FacesMessage("Account created Successfully.");
		String outcome = "buyMembership";
		FacesContext.getCurrentInstance().addMessage(null, message);

		return outcome;
	}

	public void validateEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Email Address is Valid");
			throw new ValidatorException(message);
		}
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

	public CreditTypes getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(CreditTypes membershipType) {
		this.membershipType = membershipType;
	}

	public void setTotalBookedClasses(int totalBookedClasses) {
		this.totalBookedClasses = totalBookedClasses;
	}

	public int getTotalBookedClasses() {

		int a = (bookedClasses == null ? 0 : bookedClasses.size());
		int b = (oneToOneClasses == null ? 0 : oneToOneClasses.size());

		return a + b;
	}

}
