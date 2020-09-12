package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.login.LoginSetup;

class LoginSetupTest {
	
	private LoginSetup login;
	
	@BeforeEach
	public void setUp() {
		System.out.println("In setup");
		login = new LoginSetup("555","Shane");
		
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
	public void testUersPasswordAndUsernameSet() {
		login.setPassword("AAA4");
		assertEquals("AAA4", login.getPassword());
		login.setUserName("Shane");
		assertEquals("Shane", login.getUserName());
	}
	
	@Test 
	public void emptyConstructorTest() {
		new LoginSetup();
	}
}
