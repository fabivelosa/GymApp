package com.ait.gym;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean
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

		Employee emp = new Employee();
		emp.setEmpName("John");

		Employee emp2 = new Employee();
		emp2.setEmpName("Paul");

		EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);
		employeeList.getEmployees().add(emp);
		employeeList.getEmployees().add(emp2);

		gymClasses = new ArrayList<GymClass>();
		GymClass pilates = new GymClass(getRandomId(), ClassesTypes.PILATES, DayOfWeek.MONDAY, "09:00", 60, 20, emp2);
		gymClasses.add(pilates);

		GymClass mindfulness = new GymClass(getRandomId(), ClassesTypes.MINDFULLNESS, DayOfWeek.TUESDAY, "10:00", 60,
				20, emp);
		gymClasses.add(mindfulness);
		GymClass circuits = new GymClass(getRandomId(), ClassesTypes.CIRCUIT, DayOfWeek.WEDNESDAY, "09:00", 60, 20,
				new Employee());
		gymClasses.add(circuits);
		GymClass yoga = new GymClass(getRandomId(), ClassesTypes.YOGA, DayOfWeek.THURSDAY, "10:00", 60, 20,
				new Employee());
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

	public ClassesTypes[] getClassTypes() {
		return ClassesTypes.values();
	}

	public ArrayList<Employee> getEmployees() {
		EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);
		return employeeList.getEmployees();
	}

	public DayOfWeek[] getDaysOfWeek() {

		return DayOfWeek.values();
	}

	public ArrayList<GymClass> getClassesbyTrainer() {

		ArrayList<GymClass> trainerClass = new ArrayList<GymClass>();

		for (GymClass classes : gymClasses) {
			if (classes.instructor.getEmpName() != null && classes.instructor.getEmpName().equals("John")) {
				trainerClass.add(classes);
			}
		}

		for (GymClass classes : gymClasses) {
			if (classes.instructor.getEmpName() == null) {
				trainerClass.add(classes);
			}
		}

		return trainerClass;
	}

	public void onRowEdit(RowEditEvent<GymClass> event) {
		FacesMessage msg = new FacesMessage("Class Edited");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent<GymClass> event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

}
