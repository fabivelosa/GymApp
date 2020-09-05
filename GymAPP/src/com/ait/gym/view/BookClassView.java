package com.ait.gym.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ait.gym.bean.GymClass;
import com.ait.gym.bean.GymClassList;
import com.ait.gym.bean.Member;
import com.ait.gym.utils.Helper;

@ManagedBean
@ViewScoped
public class BookClassView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<GymClass> gymClassesAvailable;

	public void enrollClasses(String  classes) {

		ArrayList<GymClass> availableClasses = getGymClassesAvailable();
		Member member = getUserLogged();

		for (GymClass enrolled : availableClasses) {
			if (enrolled.getId() == Integer.parseInt(classes)) {
				
				if(enrolled.getEnrolled() == null) {					  
				     enrolled.setEnrolled(new ArrayList<Member>());
				}
				enrolled.getEnrolled().add(member);
				enrolled.setSpaces(enrolled.getSpaces() - 1); // space booked
			}
		}
	}

	public Member getUserLogged() {
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

	public ArrayList<GymClass> getGymClassesAvailable() {

		System.out.println("getAllClassesAvailable");
		gymClassesAvailable = new ArrayList<GymClass>();
		GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);

		// classes that have instructor assigned and available spaces
		for (GymClass classes : gymClasses.getGymClass()) {
			if (classes.getInstructor() != null && classes.getSpaces() > 0) {
				gymClassesAvailable.add(classes);
			}
		}

		return gymClassesAvailable;
	}

	public void setGymClassesAvailable(ArrayList<GymClass> gymClassesAvailable) {
		this.gymClassesAvailable = gymClassesAvailable;
	}
}
