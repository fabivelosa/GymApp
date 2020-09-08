package com.ait.gym.utils;

import java.io.IOException;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.Member;

public class Helper {

	public static <T> T getBean(String beanName, Class<T> type) {

		// Get the FacesContext object.
		FacesContext context = FacesContext.getCurrentInstance();

		// Get the Application object for the current context.
		Application application = context.getApplication();

		// Evaluate an EL expression, to get the bean with the specified name.
		return application.evaluateExpressionGet(context, "#{" + beanName + "}", type);
	}

	public static void expungeSession() {

		// Get the FacesContext object.
		FacesContext context = FacesContext.getCurrentInstance();

		// Get the HttpSession object for the current context.
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

		// Invalidate (i.e. expunge) session state.
		if (session != null) {
			session.invalidate();
		}
	}
	
	public static void setSessionAttribute(String name, Object obj) {

		// Get the FacesContext object.
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		
	    session.setAttribute(name, obj);	
	
		
	}
	
	public static Member getUserLogged() {
		System.out.println("getUserLogged");
		Member member = new Member();

		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
		String loggedUser = (String) session.getAttribute("isUserLogged");
		String userType = (String) session.getAttribute("userType");

		if (loggedUser != null && loggedUser.equals("true") && userType != null && userType.equals("M")) {
			member = (Member) session.getAttribute("loggedUser");

		}
		return member;
	}
	
	public static Employee getTrainerLogged() {
		System.out.println("getTrainerLogged");
		Employee trainer = new Employee();

		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
		String loggedUser = (String) session.getAttribute("isUserLogged");
		String userType = (String) session.getAttribute("userType");

		if (loggedUser != null && loggedUser.equals("true") && userType != null && userType.equals("E")) {
			trainer = (Employee) session.getAttribute("loggedUser");

		}
		return trainer;
	}
}