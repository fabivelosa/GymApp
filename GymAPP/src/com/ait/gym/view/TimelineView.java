package com.ait.gym.view;

import java.time.DayOfWeek;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

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

	public void onRowEdit(RowEditEvent<GymClass> event) {
		FacesMessage msg = new FacesMessage("Class Edited");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		getClassesbyTrainer();

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
		getClassesbyTrainer();
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

	public static void update(String id) {
		PrimeFaces pf = PrimeFaces.current(); // RequestContext.getCurrentInstance() for <PF 6.2
		if (pf.isAjaxRequest())
			pf.ajax().update(id);
	}

	/** Whether onCellEdit changed the value */
	boolean onCellEditChange;

	public void onCellEditRemote() {
		if (!onCellEditChange)
			update("testContainer");
	}
	
	 

	public ArrayList<GymClass> getClassesbyTrainer() {
		trainerClass = new ArrayList<GymClass>();
		GymClassList gymClasses = Helper.getBean("gymClassList", GymClassList.class);
		
				Employee emp = Helper.getTrainerLogged();
				
				for (GymClass classes : gymClasses.getGymClass()) {
					if (classes.getInstructor() != null) {
						if (classes.getInstructor().getEmpName() != null && classes.getInstructor().getEmpName().equals(emp.getEmpName())) {
							trainerClass.add(classes);
						}
					}
				}
		
				for (GymClass classes : gymClasses.getGymClass()) {
					if (classes != null && classes.getInstructor()  == null) {
						trainerClass.add(classes);
					}
				}

		return trainerClass;
	}
	
	public void submmit() {
	
	}

}
   