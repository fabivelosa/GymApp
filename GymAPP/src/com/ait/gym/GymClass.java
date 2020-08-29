package com.ait.gym;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class GymClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String dayOfWeek;
	private String time;
	private int duration;
	private int spaces;
	Employee instructor;

	public GymClass() {
		super();
	}

	public GymClass(String name, String dayOfWeek, String time, int duration, int spaces, Employee instructor) {
		super();
		this.name = name;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.duration = duration;
		this.spaces = spaces;
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getSpaces() {
		return spaces;
	}

	public void setSpaces(int spaces) {
		this.spaces = spaces;
	}

	public Employee getInstructor() {
		return instructor;
	}

	public void setInstructor(Employee instructor) {
		this.instructor = instructor;
	}
}
