package com.ait.gym.bean.lists;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.GymClass;
import com.ait.gym.utils.ClassesTypes;
import com.ait.gym.utils.Helper;

@ManagedBean(name = "gymClassList", eager = true)
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

		// Add personal trainers
		EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);
		Employee emp = employeeList.getEmployeeByUserName("john@gmail.com");
		Employee emp2 = employeeList.getEmployeeByUserName("paul@gmail.com");

		gymClasses = new ArrayList<GymClass>();
		List<GymClass> empClasses = new ArrayList<GymClass>();
		List<GymClass> emp2Classes = new ArrayList<GymClass>();

		GymClass pilates = new GymClass(getRandomId(), ClassesTypes.PILATES, DayOfWeek.MONDAY, "09:00", 60, 20, emp2);
		gymClasses.add(pilates);
		emp2Classes.add(pilates);

		GymClass mindfulness = new GymClass(getRandomId(), ClassesTypes.MINDFULLNESS, DayOfWeek.TUESDAY, "10:00", 60,
				20, emp);
		empClasses.add(mindfulness);
		gymClasses.add(mindfulness);

		GymClass circuits = new GymClass(getRandomId(), ClassesTypes.CIRCUIT, DayOfWeek.WEDNESDAY, "09:00", 60, 10);
		gymClasses.add(circuits);

		GymClass yoga = new GymClass(getRandomId(), ClassesTypes.YOGA, DayOfWeek.THURSDAY, "10:00", 40, 20);
		gymClasses.add(yoga);

		GymClass taichi = new GymClass(getRandomId(), ClassesTypes.TAI_CHI, DayOfWeek.FRIDAY, "11:00", 60, 20, emp);
		gymClasses.add(taichi);
		empClasses.add(taichi);

		GymClass pilates1 = new GymClass(getRandomId(), ClassesTypes.PILATES, DayOfWeek.WEDNESDAY, "09:00", 60, 20,
				emp2);
		gymClasses.add(pilates1);
		emp2Classes.add(pilates1);

		GymClass mindfulness1 = new GymClass(getRandomId(), ClassesTypes.MINDFULLNESS, DayOfWeek.THURSDAY, "10:00", 60,
				20, emp);
		gymClasses.add(mindfulness1);
		empClasses.add(mindfulness1);

		GymClass circuits1 = new GymClass(getRandomId(), ClassesTypes.CIRCUIT, DayOfWeek.WEDNESDAY, "09:00", 60, 10);
		gymClasses.add(circuits1);
		GymClass yoga1 = new GymClass(getRandomId(), ClassesTypes.YOGA, DayOfWeek.TUESDAY, "10:00", 40, 20);
		gymClasses.add(yoga1);
		GymClass taichi1 = new GymClass(getRandomId(), ClassesTypes.TAI_CHI, DayOfWeek.FRIDAY, "09:00", 60, 20, emp);
		gymClasses.add(taichi1);
		empClasses.add(taichi1);

		// 1-to-1 session
		GymClass personal = new GymClass(getRandomId(), ClassesTypes.ONE_ONE_SESSION, DayOfWeek.MONDAY, "11:00", 50, 1,
				emp);
		gymClasses.add(personal);
		empClasses.add(personal);

		GymClass personal1 = new GymClass(getRandomId(), ClassesTypes.ONE_ONE_SESSION, DayOfWeek.TUESDAY, "12:00", 50,
				1, emp);
		gymClasses.add(personal1);
		empClasses.add(personal1);
		GymClass personal2 = new GymClass(getRandomId(), ClassesTypes.ONE_ONE_SESSION, DayOfWeek.WEDNESDAY, "13:00", 50,
				1, emp);
		gymClasses.add(personal2);
		empClasses.add(personal2);

		emp.setBookedClasses(empClasses);
		emp2.setBookedClasses(emp2Classes);

		// 1-to-1 session NoTrainer
		GymClass personal3 = new GymClass(getRandomId(), ClassesTypes.ONE_ONE_SESSION, DayOfWeek.THURSDAY, "15:00", 50,
				1);
		gymClasses.add(personal3);

		GymClass personal4 = new GymClass(getRandomId(), ClassesTypes.ONE_ONE_SESSION, DayOfWeek.FRIDAY, "19:00", 50,
				1);
		gymClasses.add(personal4);

		GymClass personal5 = new GymClass(getRandomId(), ClassesTypes.ONE_ONE_SESSION, DayOfWeek.SATURDAY, "14:00", 50,
				1);
		gymClasses.add(personal5);
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

	public static GymClass getGymClassbyId(int id) {

		GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);

		for (GymClass classes : gymClasses.getGymClass()) {

			if (classes.getId() == id) {
				return classes;
			}
		}

		return null;

	}

}
