package com.ait.gym.bean.lists;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.gym.bean.Employee;

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
		emp.setUserName("john@gmail.com");
		emp.setPassword("1234");

		Employee emp2 = new Employee("Paul");
		emp2.setUserName("paul@gmail.com");
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

	public Employee getEmployeeByUserName(String userName) {

		Employee employeeFound = null;

		for (Employee emp : this.getEmployees()) {
			if (emp != null && emp.getUserName().equals(userName)) {
				employeeFound = emp;
				System.out.println("emp found -->" + emp.getFirstName());
			}
		}
		return employeeFound;
	}

}
