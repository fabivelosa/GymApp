package com.ait.gym.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ait.gym.bean.GymClass;
import com.ait.gym.bean.Member;
import com.ait.gym.bean.lists.GymClassList;
import com.ait.gym.utils.ClassesTypes;
import com.ait.gym.utils.Helper;

@ManagedBean
@ViewScoped
public class BookClassView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<GymClass> gymClassesAvailable;
	List<GymClass> gymClassesBooked;
	List<GymClass> oneToOneSessionsAvaliable;
	List<GymClass> oneToOneSessionsBooked;

	public List<GymClass> getOneToOneSessions() {
		return oneToOneSessionsAvaliable;
	}

	public void setOneToOneSessions(List<GymClass> oneToOneSessions) {
		this.oneToOneSessionsAvaliable = oneToOneSessions;
	}

	public void setGymClassesAvailable(List<GymClass> gymClassesAvailable) {
		this.gymClassesAvailable = gymClassesAvailable;
	}

	public void setGymClassesBooked(List<GymClass> gymClassesBooked) {
		this.gymClassesBooked = gymClassesBooked;
	}

	@PostConstruct
	public void init() {
		gymClassesAvailable = new ArrayList<GymClass>();
		gymClassesBooked = new ArrayList<GymClass>();
		oneToOneSessionsAvaliable = new ArrayList<GymClass>();
	}

	public void enrollClasses(String classesId) {

		Member member = getUserLogged();
		GymClass gymClass = GymClassList.getGymClassbyId(Integer.parseInt(classesId));

		if (member.getBookedClasses() == null) {
			List<GymClass> list = new ArrayList<GymClass>();
			member.setBookedClasses(list);
		}
		member.getBookedClasses().add(gymClass);
		gymClass.setSpaces(gymClass.getSpaces() - 1);
		if (gymClass.getEnrolled() == null) {
			List<Member> list = new ArrayList<Member>();
			gymClass.setEnrolled(list);
		}

		gymClass.getEnrolled().add(member);
	}

	public void enrollOneToOneSession(String classesId) {

		Member member = getUserLogged();
		GymClass gymClass = GymClassList.getGymClassbyId(Integer.parseInt(classesId));

		if (member.getOneToOneCredit() > 0) {
			if (member.getOneToOneClasses() == null) {
				List<GymClass> list = new ArrayList<GymClass>();
				member.setOneToOneClasses(list);
			}
			member.getOneToOneClasses().add(gymClass);
			gymClass.setSpaces(gymClass.getSpaces() - 1);

			if (gymClass.getEnrolled() == null) {
				List<Member> list = new ArrayList<Member>();
				gymClass.setEnrolled(list);
			}

			gymClass.getEnrolled().add(member);
			member.setOneToOneCredit(member.getOneToOneCredit() - 1);
		} else {
			FacesMessage message = new FacesMessage("Sorry !! You don't have enough credits!");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	}

	public void cancelEnroll(String classesId) {
		Member member = getUserLogged();
		GymClass gymClass = GymClassList.getGymClassbyId(Integer.parseInt(classesId));
		member.getBookedClasses().remove(gymClass);
		gymClass.setSpaces(gymClass.getSpaces() + 1);
		gymClass.getEnrolled().remove(member);

	}

	public void cancelOneToOneEnroll(String classesId) {
		Member member = getUserLogged();
		GymClass gymClass = GymClassList.getGymClassbyId(Integer.parseInt(classesId));
		member.getOneToOneClasses().remove(gymClass);
		gymClass.setSpaces(gymClass.getSpaces() + 1);
		gymClass.getEnrolled().remove(member);
		member.setOneToOneCredit(member.getOneToOneCredit() + 1);

	}

	public Member getUserLogged() {
		return (Member) Helper.getUserLogged();
	}

	public List<GymClass> getGymClassesAvailable() {

		System.out.println("getAllClassesAvailable");
		gymClassesAvailable = new ArrayList<GymClass>();
		GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);
		Member member = getUserLogged();
		getGymClassesBooked();

		// classes that have instructor assigned/available spaces/not already enrolled
		for (GymClass classes : gymClasses.getGymClass()) {
			if (classes.getInstructor() != null && classes.getSpaces() > 0
					&& !classes.getName().equals(ClassesTypes.ONE_ONE_SESSION)) {
				if (classes.getEnrolled() != null) {
					Boolean exits = false;
					for (Member memberItem : classes.getEnrolled()) {
						if (memberItem.getId().equals(member.getId())) {
							exits = true;
						}
					}
					if (exits == false) {
						gymClassesAvailable.add(classes);
					}
				} else {
					gymClassesAvailable.add(classes);
				}

			}
		}
		return gymClassesAvailable;
	}

	public List<GymClass> getOneToOneClassesAvailable() {

		oneToOneSessionsAvaliable = new ArrayList<GymClass>();
		GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);
		Member member = getUserLogged();

		// classes that have instructor assigned/available spaces/not already enrolled
		for (GymClass classes : gymClasses.getGymClass()) {
			if (classes.getInstructor() != null && classes.getSpaces() > 0
					&& classes.getName().equals(ClassesTypes.ONE_ONE_SESSION)) {
				oneToOneSessionsAvaliable.add(classes);
			}

		}

		return oneToOneSessionsAvaliable;
	}

	public List<GymClass> getGymClassesBooked() {
		System.out.println("gymClassesBooked");
		gymClassesBooked = getUserLogged().getBookedClasses();
		return gymClassesBooked;

	}

	public List<GymClass> getGymClassesOneToOneBooked() {
		System.out.println("gymClassesBooked");
		oneToOneSessionsBooked = getUserLogged().getOneToOneClasses();
		return oneToOneSessionsBooked;

	}

	public void setGymClassesAvailable(ArrayList<GymClass> gymClassesAvailable) {
		this.gymClassesAvailable = gymClassesAvailable;
	}

	public void setGymClassesBooked(ArrayList<GymClass> gymClassesBooked) {
		this.gymClassesBooked = gymClassesBooked;
	}

}
