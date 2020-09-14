package com.ait.gym.utils;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ait.gym.bean.Person;

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

	public static Person getUserLogged() {

		Person person = null;

		FacesContext context2 = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context2.getExternalContext().getSession(true);
		String loggedUser = (String) session.getAttribute("isUserLogged");
		String userType = (String) session.getAttribute("userType");

		if (loggedUser != null && loggedUser.equals("true") && userType != null) {
			person = (Person) session.getAttribute("loggedUser");

		}
		return person; 
	}

	public static void setInfoMessage(String summary,String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, message));
	}

	public static void setInfoMessage(UIComponent component, String summary,String message) {

		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(component.getClientId(context), new FacesMessage(summary, message));

	}

}