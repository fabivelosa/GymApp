package com.ait.gym.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ait.gym.bean.Employee;
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
	List<GymClass> gymClassesAvailable;
	List<GymClass> gymClassesBooked;

	
	@PostConstruct
	public void init() {
		gymClassesAvailable= new  ArrayList<GymClass>();
		gymClassesBooked = new ArrayList<GymClass>(); 
	}
	
	
	public void enrollClasses(String classesId) {

		Member member = getUserLogged();
		GymClass gymClass = GymClassList.getGymClassbyId(Integer.parseInt(classesId));
		if(member.getBookedClasses()== null) {
			List<GymClass> list = new ArrayList<GymClass>();
			member.setBookedClasses(list);
		}
		member.getBookedClasses().add(gymClass);
		gymClass.setSpaces(gymClass.getSpaces() - 1);
		if(gymClass.getEnrolled()== null) {
			List<Member> list = new ArrayList<Member>();
			gymClass.setEnrolled(list);
		}
		
		gymClass.getEnrolled().add(member);
	}

	public void cancelEnroll(String classesId) {		
		Member member = getUserLogged();
		GymClass gymClass = GymClassList.getGymClassbyId(Integer.parseInt(classesId)); 
		member.getBookedClasses().remove(gymClass);
		gymClass.setSpaces(gymClass.getSpaces() + 1);
		gymClass.getEnrolled().remove(member);

		
	}

	public Member getUserLogged() {
		return Helper.getUserLogged();
	}

	public List<GymClass> getGymClassesAvailable() {

		System.out.println("getAllClassesAvailable");
		gymClassesAvailable = new ArrayList<GymClass>();
		GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);
		Member member = getUserLogged();
		getGymClassesBooked();

		// classes that have instructor assigned/available spaces/not already enrolled
		for (GymClass classes : gymClasses.getGymClass()) {
			if (classes.getInstructor() != null && classes.getSpaces() > 0) {
			   if(classes.getEnrolled() != null ) {
				   Boolean exits= false;
				   for(Member memberItem : classes.getEnrolled()) {
					   if( memberItem.getMemberID().equals(member.getMemberID())) {
						   exits = true;
					   }
				   }				   
				   if(exits == false) {
					   gymClassesAvailable.add(classes);
				   }
			   }else {
				   gymClassesAvailable.add(classes);
			   }
				  
			}
		}
		return gymClassesAvailable;
	}

	public List<GymClass> getGymClassesBooked() {
		System.out.println("gymClassesBooked");
		gymClassesBooked = getUserLogged().getBookedClasses();	
		return gymClassesBooked;

	}

	public void setGymClassesAvailable(ArrayList<GymClass> gymClassesAvailable) {
		this.gymClassesAvailable = gymClassesAvailable;
	}

	public void setGymClassesBooked(ArrayList<GymClass> gymClassesBooked) {
		this.gymClassesBooked = gymClassesBooked;
	}

}
