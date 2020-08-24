package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.Login;

class LoginTest {
	
	private Login login;
	
	private String userName = "";
	private String password = "";
	
	@BeforeEach
	public void setUp() {
		System.out.println("In setup");
		login = new Login();
		
	}
	

	@Test
	public void testUserName() {
		assertEquals("Shane", login.getUserName());
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
