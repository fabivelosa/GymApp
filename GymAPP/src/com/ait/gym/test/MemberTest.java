package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.Member;

class MemberTest {

	private Member member;

	@BeforeEach
	void setUp() throws Exception {
		Date date = new Date();

		member = new Member("0", "Fabiane", "Velosa", date, "083-123456", "fabi@gmail", "17, address", "Athlone",
				"Female", "Improve metabolism", "N37896", "fabi", "123");
	}

	@Test
	void testMemberContructor() {
		assertEquals("M1003", member.getMemberID());
		assertEquals("Fabiane", member.getFirstName(), "First Name");
		assertEquals("Velosa", member.getLastName(), "Last Name");
		assertEquals("083-123456", member.getMobileNumber(), "Mobile");
		assertEquals("17, address", member.getAddress(), "Address");
		assertEquals("Athlone", member.getCity(), "City");
		assertEquals("fabi@gmail", member.getEmailAddress(), "Email address");
		assertEquals("Female", member.getGender(), "Gender");
		assertEquals("Improve metabolism", member.getGoal(), "Goal");
	}

	@Test
	void testSetFullName() {
		member.setFirstName("Fabi");
		member.setLastName("Cavalcanti");
		assertEquals("Fabi", member.getFirstName(), "First Name");
		assertEquals("Cavalcanti", member.getLastName(), "Last Name");
	}

	@Test
	void testSetFullAddress() {
		member.setAddress("15, Cloghanboy");
		member.setEircode("F154789");
		member.setCity("Dublin");
		assertEquals("15, Cloghanboy", member.getAddress(), "Address");
		assertEquals("Dublin", member.getCity(), "City");
		assertEquals("F154789", member.getEircode(), "EirCode");
	}

	@Test
	void testSetDateOfBirth() {
		Date dob = new Date();
		member.setDob(dob);
		assertEquals(dob, member.getDob());
	}

	@Test
	void testSetEmail() {
		member.setEmailAddress("fabi@gmail");
		assertEquals("fabi@gmail", member.getEmailAddress());
	}

	@Test
	void testSetGoal() {
		member.setGoal("Hiit");
		assertEquals("Hiit",member.getGoal());
	}
}
