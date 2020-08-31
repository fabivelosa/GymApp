package com.ait.gym.bean;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.gym.utils.ClassesTypes;
import com.ait.gym.utils.Helper;

@ManagedBean(name="gymClassList",eager=true)
@SessionScoped
public class GymClassList implements Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L; 
	private ArrayList<GymClass> gymClasses;
 
	public GymClassList() {
		super();
	}

	@PostConstruct
	public void init() {

		Employee emp = new Employee("John");
		Employee emp2 = new Employee("Paul");		

		EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);
		employeeList.getEmployees().add(emp);
		employeeList.getEmployees().add(emp2);

		gymClasses = new ArrayList<GymClass>();
		GymClass pilates = new GymClass(getRandomId(), ClassesTypes.PILATES, DayOfWeek.MONDAY, "09:00", 60, 20, emp2);
		gymClasses.add(pilates); 

		GymClass mindfulness = new GymClass(getRandomId(), ClassesTypes.MINDFULLNESS, DayOfWeek.TUESDAY, "10:00", 60,
				20, emp);
		gymClasses.add(mindfulness);
		GymClass circuits = new GymClass(getRandomId(), ClassesTypes.CIRCUIT, DayOfWeek.WEDNESDAY, "09:00", 60, 20);
		gymClasses.add(circuits);
		GymClass yoga = new GymClass(getRandomId(), ClassesTypes.YOGA, DayOfWeek.THURSDAY, "10:00", 60, 20);
		gymClasses.add(yoga);
		GymClass taichi = new GymClass(getRandomId(), ClassesTypes.TAI_CHI, DayOfWeek.FRIDAY, "11:00", 60, 20, emp);
		gymClasses.add(taichi);
		GymClass personal = new GymClass(getRandomId(), ClassesTypes.ONE_ONE_SESSION, DayOfWeek.MONDAY, "11:00", 60, 20,
				emp);
		gymClasses.add(personal);

	}

	public ArrayList<GymClass> getGymClass() {
		return gymClasses;
	}

	private int getRandomId() {
		Random rn = new Random();
		return rn.nextInt(1000);
	}

	public void setGymClass(ArrayList<GymClass> gymClasses) {
		this.gymClasses = gymClasses;
	}

	

	

}
