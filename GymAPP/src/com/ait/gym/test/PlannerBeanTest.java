package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.Member;
import com.ait.gym.bean.PlannerBean;

class PlannerBeanTest {

	private PlannerBean plannerbean;

	@BeforeEach
	void setUp() {

		System.out.println("Test running");
		plannerbean = new PlannerBean();
	}

	@Test
	public void testMondaySessionPass() {
		String[] expectedOutput = { "stretching", "cycling", "muscle training" };
		String[] mondaySession = { "stretching", "cycling", "muscle training" };
		assertArrayEquals(expectedOutput, mondaySession);
	}

	@Test
	public void testMondaySessionFail() {
		String[] expectedOutput = { "rest" };
		String[] tuesdaySession = { "rest" };
		assertArrayEquals(expectedOutput, tuesdaySession);
	}

	@Test
	public void testMember() {
		assertEquals(null, plannerbean.getMember());
	}

	@Test
	public void testMemberset() {
		Member member = null;
		plannerbean.setMember(member);
		assertEquals(null, plannerbean.getMember());
	}

}
