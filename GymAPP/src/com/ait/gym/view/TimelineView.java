package com.ait.gym.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.GymClass;
import com.ait.gym.bean.lists.EmployeeList;
import com.ait.gym.bean.lists.GymClassList;
import com.ait.gym.utils.ClassesTypes;
import com.ait.gym.utils.Helper;

@ManagedBean
@ViewScoped
public class TimelineView { 

	ArrayList<GymClass> trainerClass;
	ArrayList<GymClass> classesUnassigned;

	public void setClassesUnassigned(ArrayList<GymClass> classesUnassigned) {
		this.classesUnassigned = classesUnassigned; 
	}

	public ClassesTypes[] getClassTypes() {
		return ClassesTypes.values();
	}

	public ArrayList<Employee> getEmployees() {
		EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);
		return employeeList.getEmployees();
	}

	public void setTrainerClass(ArrayList<GymClass> trainerClass) {
		this.trainerClass = trainerClass;
	}

	public ArrayList<GymClass> getTrainerClass() {
		
		if(trainerClass == null || trainerClass.size() ==0) {
				trainerClass = new ArrayList<GymClass>();
				GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);
		
				Employee emp =getUserLogged();
		
				for (GymClass classes : gymClasses.getGymClass()) {
					if (classes.getInstructor() != null) {
						if (classes.getInstructor().getFirstName() != null
								&& classes.getInstructor().getFirstName().equals(emp.getFirstName())) {
							trainerClass.add(classes);
						}
					}
				}
		}
		return trainerClass; 
	}

	public ArrayList<GymClass> getclassesUnassigned() {
		
		
		if(classesUnassigned == null || classesUnassigned.size() == 0) {
						classesUnassigned = new ArrayList<GymClass>();
				GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);
		
				for (GymClass classes : gymClasses.getGymClass()) {
					if (classes != null && classes.getInstructor() == null) {
						classesUnassigned.add(classes);
					}
				}
		}

		return classesUnassigned;
	}

	
	public void assignClass(String classesId) {

		Employee emp = getUserLogged();
		GymClass gymClass = GymClassList.getGymClassbyId(Integer.parseInt(classesId));

		if (emp.getBookedClasses() == null) {
			List<GymClass> list = new ArrayList<GymClass>();
			emp.setBookedClasses(list);
		}
		emp.getBookedClasses().add(gymClass);
		gymClass.setInstructor(emp);

	}
	
	public Employee getUserLogged() {
		return (Employee) Helper.getUserLogged();
	}

	public void cancelAssignClass(String classesId) {
		Employee emp = getUserLogged();
		GymClass gymClass = GymClassList.getGymClassbyId(Integer.parseInt(classesId));
		if(emp.getBookedClasses() != null) {
			emp.getBookedClasses().remove(gymClass);
		}
		gymClass.setInstructor(null);

	}

}
