package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.lists.EmployeeList;

class EmployeeListTest {

	private Employee emp;
	private Employee emp2;
	private EmployeeList employeeList;
	private ArrayList<Employee> employees;

	@BeforeEach
	void setUp() throws Exception {
		employees = new ArrayList<Employee>();
		employeeList = new EmployeeList();

		emp = new Employee("John");
		emp.setUserName("john@gmail.com");
		emp.setPassword("1234");

		emp2 = new Employee("Paul");
		emp2.setUserName("paul@gmail.com");
		emp2.setPassword("1234");

		employees.add(emp);
		employees.add(emp2);
		employeeList.setEmployees(employees);

	}

	@Test
	void testGetEmployeeByUserName() {
		assertEquals(emp, employeeList.getEmployeeByUserName("john@gmail.com"));
		assertEquals(emp2, employeeList.getEmployeeByUserName("paul@gmail.com"));
	}

}
