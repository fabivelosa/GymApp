package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.Person;
import com.ait.gym.bean.login.Login;
import com.ait.gym.bean.login.LoginSetup;

class LoginTest {

private Login login;
	
	@BeforeEach
	public void setUp() {
		System.out.println("In login");
		login = new Login();
		
	}
	
	@Test
	public void loginResponseTest() {
		assertEquals("index.xhtml?faces-redirect=true", login.loginYesNo());
	}
	
	
	
	
	

}
