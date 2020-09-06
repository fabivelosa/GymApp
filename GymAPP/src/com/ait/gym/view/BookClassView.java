package com.ait.gym.view;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ait.gym.bean.GymClass;
import com.ait.gym.bean.Member;
import com.ait.gym.bean.lists.GymClassList;
import com.ait.gym.utils.Helper;

@ManagedBean
@ViewScoped
public class BookClassView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<GymClass> gymClassesAvailable;
	ArrayList<GymClass> gymClassesBooked;

	public void enrollClasses(String classes) {

		ArrayList<GymClass> availableClasses = getGymClassesAvailable();
		Member member = getUserLogged();

		for (GymClass enrolled : availableClasses) {
			if (enrolled.getId() == Integer.parseInt(classes)) {

				if (enrolled.getEnrolled() == null) {
					enrolled.setEnrolled(new ArrayList<Member>());
				}
				enrolled.getEnrolled().add(member);
				enrolled.setSpaces(enrolled.getSpaces() - 1); // space booked
			}
		}
	}

	public void cancelEnroll(String classes) {

		ArrayList<GymClass> bookedClasses = getGymClassesBooked();
		Member member = getUserLogged();

		for (GymClass enrolled : bookedClasses) {
			if (enrolled.getId() == Integer.parseInt(classes)) {

				if (enrolled.getEnrolled() == null) {
					enrolled.setEnrolled(new ArrayList<Member>());
				}
				enrolled.getEnrolled().remove(member);
				enrolled.setSpaces(enrolled.getSpaces() + 1); // space released
			}
		}
	}

	public Member getUserLogged() {
		return Helper.getUserLogged();
	}

	public ArrayList<GymClass> getGymClassesAvailable() {

		System.out.println("getAllClassesAvailable");
		gymClassesAvailable = new ArrayList<GymClass>();
		GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);

		// classes that have instructor assigned/available spaces/not already enrolled
		for (GymClass classes : gymClasses.getGymClass()) {
			if (classes.getInstructor() != null && classes.getSpaces() > 0
					&& !getGymClassesBooked().contains(classes)) {
				gymClassesAvailable.add(classes);
			}
		}
		return gymClassesAvailable;
	}

	public ArrayList<GymClass> getGymClassesBooked() {

		System.out.println("gymClassesBooked");
		gymClassesBooked = new ArrayList<GymClass>();
		GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);

		Member member = getUserLogged();
		// classes that member logged booked
		for (GymClass classes : gymClasses.getGymClass()) {
			if (classes.getEnrolled() == null) {
				classes.setEnrolled(new ArrayList<Member>());
			}
			for (Member memberEnroll : classes.getEnrolled()) {
				if (memberEnroll.equals(member)) {
					gymClassesBooked.add(classes);
				}
			}
		}
		return gymClassesBooked;
	}

	public void setGymClassesAvailable(ArrayList<GymClass> gymClassesAvailable) {
		this.gymClassesAvailable = gymClassesAvailable;
	}

	public void setGymClassesBooked(ArrayList<GymClass> gymClassesBooked) {
		this.gymClassesBooked = gymClassesBooked;
	}

}
