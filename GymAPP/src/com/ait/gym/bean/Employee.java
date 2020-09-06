package com.ait.gym.bean;

import java.util.Date;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.ait.gym.utils.Helper;

@ManagedBean(name="employee")
@SessionScoped
public class Employee {

	// Member Variables
	private String employeeID;
	private String empName;
	private String gender;
	private Date dob;
	private String address;
	private String emailAddress;
	private String mobileNumber;
	private String password;
	private String aboutYourself;
	private boolean employeeType;
	

 
	static int range = 1000;
	
	public Employee () {
		Random random = new Random();    
		this.setEmployeeID("P" + random.nextInt(range));		
	}
	
	
	public Employee (String name) {
		Random random = new Random();    
		this.setEmployeeID("P" + random.nextInt(range));		
		this.setEmpName(name);
	}
	
	
	public Employee(String empName, String gender, Date dob, String address, String emailAddress, String mobileNumber,
			String password, String aboutYourself, boolean employeeType) {
		super();
		
		this.empName=empName;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.aboutYourself = aboutYourself; 
		this.employeeType = employeeType;
		
		Random random = new Random();    
		this.setEmployeeID("P" + random.nextInt(range));
	}
	
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAboutYourself() {
		return aboutYourself;
	}

	public void setAboutYourself(String aboutYourself) {
		this.aboutYourself = aboutYourself;
	}

	public boolean isEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(boolean employeeType) {
		this.employeeType = employeeType;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
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
	public String storeEmployeeInfo() {

		
		String outcome = null;

		EmployeeList employees = Helper.getBean("employeeList", EmployeeList.class);
		employees.getEmployees().add(this);

		FacesMessage message   = new FacesMessage("Employee Information is stored Successfully.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		outcome = "login";		
		return outcome;
	}
}
