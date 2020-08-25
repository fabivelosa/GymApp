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
		login = new Login("555","Shane");
		
	}
	
	@Test
	public void testUserPassword() {
		assertEquals("555",login.getPassword());
	}

	@Test
	public void testUserName() {
		assertEquals("Shane", login.getUserName());
	}
	
	@Test
	public void testUserPasswordIncorrect() {
		assertNotEquals("billyBob", login.getPassword());
	}
	@Test 
	public void testUserNameIncorrect() {
		assertNotEquals("5555", login.getUserName());
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
