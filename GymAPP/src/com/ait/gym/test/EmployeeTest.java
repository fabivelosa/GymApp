package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.Employee;
import com.ait.gym.utils.CreditTypes;

class EmployeeTest {

	private Employee employee;

	@BeforeEach
	void setUp() throws Exception {
		Date date = new Date();
		employee = new Employee("Fabi", "Female", date, "17, address - Athlone", "fabi@gmail", "083-123456", "fabi",
				"123", "Java is my favorite class.", true);
	}

	@Test
	void testEmployeeIDContructor() {
		employee = new Employee();
		assertTrue(employee.getId().contains("P"), employee.getId());
	}

	@Test
	void testEmployeeContructor() {
		assertTrue(employee.getId().contains("P"), employee.getId());
		assertEquals("Fabi", employee.getFirstName(), "First Name");
		assertEquals("083-123456", employee.getMobileNumber(), "Mobile");
		assertEquals("17, address - Athlone", employee.getAddress(), "Address");
		assertEquals("fabi@gmail", employee.getEmailAddress(), "Email address");
		assertEquals("Female", employee.getGender(), "Gender");
		assertTrue(employee.isEmployeeType(), "Permanent?");
	}

	@Test
	void testSetFullName() {
		employee.setFirstName("Fabi");
		employee.setLastName("Cavalcanti");
		assertEquals("Fabi", employee.getFirstName(), "First Name");
	}

	@Test
	void testSetLogin() {
		employee.setUserName("Fabi");
		employee.setPassword("123456");
		assertEquals("Fabi", employee.getUserName(), "UserName");
		assertEquals("123456", employee.getPassword(), "Password");
	}

	@Test
	void testSetFullAddress() {
		employee.setAddress("15, Cloghanboy");
		employee.setEircode("F154789");
		employee.setCity("Dublin");
		assertEquals("15, Cloghanboy", employee.getAddress(), "Address");
		assertEquals("Dublin", employee.getCity(), "City");
		assertEquals("F154789", employee.getEircode(), "EirCode");
	}

	@Test
	void testSetDateOfBirth() {
		Date dob = new Date();
		employee.setDob(dob);
		assertEquals(dob, employee.getDob());
	}

	@Test
	void testSetEmail() {
		employee.setEmailAddress("fabi@gmail");
		assertEquals("fabi@gmail", employee.getEmailAddress());
	}

	@Test
	void testSetMobile() {
		employee.setMobileNumber("085123456");
		assertEquals("085123456", employee.getMobileNumber());
	}

	@Test
	void testSetGender() {
		employee.setGender("female");
		assertEquals("female", employee.getGender());
	}

	@Test
	void testSetPermanent() {
		employee.setEmployeeType(true);
		assertTrue(employee.isEmployeeType());
	}

	@Test
	void testSetAboutYou() {
		employee.setAboutYourself("Love JSF");
		assertEquals("Love JSF", employee.getAboutYourself());
	}

}
