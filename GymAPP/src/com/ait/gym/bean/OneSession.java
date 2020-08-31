package com.ait.gym.bean;

import java.io.Serializable;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class OneSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private int age;
	private String emailAddress;
	private String dateDay;
	private String dateTime;
	
	private String uniqueCode;
	private String enteredCode;
	static int count = 1000;
	boolean hasRegistered;
	boolean codeAccepted;

	public OneSession() {
		super();
		count++;
	}
	
	public OneSession(String firstName, String lastName, int age, String emailAddress, 
				   String dateDay, String dateTime) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.emailAddress = emailAddress;
		this.dateDay = dateDay;
		this.dateTime = dateTime;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public String getDateDay() {
		return dateDay;
	}

	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isHasRegistered() {
		return hasRegistered;
	}

	public void setHasRegistered(boolean hasRegistered) {
		this.hasRegistered = hasRegistered;
	}
	
	public boolean isCodeAccepted() {
		return codeAccepted;
	}

	public void setCodeAccepted(boolean codeAccepted) {
		this.codeAccepted = codeAccepted;
	}
	
	public String getEnteredCode() {
		return enteredCode;
	}
	
	public void setEnteredCode(String enteredCode) {
		this.enteredCode = enteredCode;
	}

	public void validateEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Email Address is Invalid");
			throw new ValidatorException(message);
		}
	}
	
	public String createSession() {
		hasRegistered = true;
		uniqueCode = UUID.randomUUID().toString();
		System.out.println(uniqueCode + ", " + hasRegistered + ", " + codeAccepted);
		FacesMessage message = new FacesMessage("Session created Successfully.");
		String outcome = "sessionsuccess";
		FacesContext.getCurrentInstance().addMessage(null, message);
		return outcome;
	}
	
	public String checkCode(String enteredCode) {
		setEnteredCode(enteredCode);
		if(uniqueCode.equals(enteredCode)) {
			setCodeAccepted(true);
			System.out.println(codeAccepted + ": code accepted");
			return null;
		} else {
			System.out.println(codeAccepted + ": code not accepted");
			return null;
		}
	}
}
