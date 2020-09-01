package com.ait.gym.utils;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.EmployeeList;
import com.ait.gym.bean.GymClassList;

@FacesConverter(value = "SelectItemToEntityConverter", forClass = GymClassList.class)
public class SelectItemToEntityConverter implements Converter {

	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		if (modelValue == null || modelValue == "" ) {
			return "";
		}

		if (modelValue instanceof Employee) {
			return ((Employee)modelValue).getEmployeeID();
		} else {
			throw new ConverterException(new FacesMessage(modelValue + " is not a valid Employee"));
		}
	}

	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		if (submittedValue == null || submittedValue.isEmpty()) {
			return null;
		}

		try {
			EmployeeList employeeList = Helper.getBean("employeeList", EmployeeList.class);

			Employee emp = null;
			for (Employee emp1 : employeeList.getEmployees()) {
				if (emp1.getEmployeeID().contentEquals(submittedValue)) {
					emp = emp1;
				}
			}

			return emp;

		} catch (NumberFormatException e) {
			throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Employee ID"), e);
		}
	}
}
