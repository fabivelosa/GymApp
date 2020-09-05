package com.ait.gym.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.gym.utils.Helper;

@ManagedBean(name = "employeeList", eager = true)
@SessionScoped
public class EmployeeList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public EmployeeList() {

	}
	
	@PostConstruct
	public void init() {
		
		Employee emp = new Employee("John");
		emp.setEmailAddress("john@gmail.com");
		emp.setPassword("1234"); 

		
		Employee emp2 = new Employee("Paul");
		emp2.setEmailAddress("paul@gmail.com"); 
		emp2.setPassword("1234");

		getEmployees().add(emp);
		getEmployees().add(emp2);
		
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployeeByUserEmail(String email) {

		Employee employeeFound = null;

		for (Employee emp : this.getEmployees()) {
			if (emp.getEmailAddress().equals(email)) {
				employeeFound = emp;
				System.out.println("emp found -->" + emp.getEmpName());
			}
		}
		return employeeFound;
	}

}
