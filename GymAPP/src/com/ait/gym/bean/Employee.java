package com.ait.gym.bean;

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

import com.ait.gym.bean.lists.EmployeeList;
import com.ait.gym.interfaces.UserActions;
import com.ait.gym.utils.Helper;

@ManagedBean(name = "employee")
@RequestScoped
public class Employee extends Person implements UserActions {

	// Member Variables
	private String aboutYourself;
	private boolean employeeType;
	private List<GymClass> bookedClasses;

	static int range = 1000;

	public Employee() {
		Random random = new Random();
		this.setId("P" + random.nextInt(range));
	}

	@PostConstruct
	public void init() {
		bookedClasses = new ArrayList<GymClass>();

	}

	public Employee(String name) {
		Random random = new Random();
		this.setId("P" + random.nextInt(range));
		this.setFirstName(name);
	}

	public Employee(String empName, String gender, Date dob, String address, String emailAddress, String mobileNumber,
			String userName, String password, String aboutYourself, boolean employeeType) {
		super();

		this.setFirstName(empName);
		this.setGender(gender);
		this.setDob(dob);
		this.setAddress(address);
		this.setEmailAddress(emailAddress);
		this.setMobileNumber(mobileNumber);
		this.setPassword(password);
		this.aboutYourself = aboutYourself;
		this.employeeType = employeeType;
		this.setUserName(userName);
		Random random = new Random();
		this.setId("P" + random.nextInt(range));
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

	@Override
	public String storeInfo() {

		String outcome = null;
		EmployeeList employees = Helper.getBean("employeeList", EmployeeList.class);
		employees.getEmployees().add(this);
		FacesMessage message = new FacesMessage("Employee Information is stored Successfully.");
		FacesContext.getCurrentInstance().addMessage(null, message);
		outcome = "login?faces-redirect=true";
		return outcome;
	}

	public List<GymClass> getBookedClasses() {
		return bookedClasses;
	}

	public void setBookedClasses(List<GymClass> bookedClasses) {
		this.bookedClasses = bookedClasses;
	}

	// Validate User Already Exists
	public void validateUserName(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String username = (String) value;
		EmployeeList emps = Helper.getBean("employeeList", EmployeeList.class);
		Employee emp = emps.getEmployeeByUserName(username);
		if (emp != null && emp.getUserName().equals(username)) {
			FacesMessage message = new FacesMessage("Username already exists!");
			throw new ValidatorException(message);
		}
	}
	
	// Validate Email
	public void validateEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Email Address is Valid");
			throw new ValidatorException(message);
		}
	}

}
