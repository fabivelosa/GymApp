package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.Member;
import com.ait.gym.MembersList;

class MemberTest {

	private Member member;
	private MembersList members;

	@BeforeEach
	void setUp() throws Exception {
		Date date = new Date();
		member = new Member("M001", "Fabiane", "Velosa", date, "083-123456", "fabi@gmail", "17, address", "Athlone",
				"Female", "Improve metabolism", "fabi", "123");
	}

	@Test
	void testMemberContructor() {
		assertEquals("Fabiane", member.getFirstName(), "First Name");
		assertEquals("Velosa", member.getLastName(), "Last Name");
		assertEquals("083-123456", member.getMobileNumber(), "Last Name");
		assertEquals("17, address", member.getAddress(), "Address");
		assertEquals("Athlone", member.getCity(), "City");
		assertEquals("fabi@gmail", member.getEmailAddress(), "Email address");
		assertEquals("Female", member.getGender(), "Gender");
		assertEquals("Improve metabolism", member.getGoal(), "Goal");
	}
	
	@Test
	void testMemberArrayList() {
		
	//	assertEquals(1, members.getMembersCount(), "Qt of members");
	}

}
