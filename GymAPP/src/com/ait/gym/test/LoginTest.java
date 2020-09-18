package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.Login;

class LoginTest {

	private Login login;

	@BeforeEach
	public void setUp() {
		System.out.println("In login");
		login = new Login();
	}

	@Test
	public void loginCredentialTest() {
		login.setUserName("Shane");
		login.setPassword("1234");
		assertEquals("Shane",login.getUserName());
		assertEquals("1234",login.getPassword());
	}

}
