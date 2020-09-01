package com.ait.gym.bean;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.gym.utils.ClassesTypes;

@ManagedBean
@RequestScoped
public class GymClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private ClassesTypes name;
	private DayOfWeek dayOfWeek; 
	private String time;
	private int duration;
	private int spaces; 

	private Employee instructor;  
	 
	ArrayList<Member> enrolled; 
 
	public GymClass() {
		super(); 
	}
	
	@PostConstruct
	public void init() {
		instructor= new Employee ("");			
	}
	
	
	public GymClass(int id,ClassesTypes name, DayOfWeek dayOfWeek, String time, int duration, int spaces) {
		super();
		this.id= id;
		this.name = name;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.duration = duration;
		this.spaces = spaces;	
	}

	public GymClass(int id,ClassesTypes name, DayOfWeek dayOfWeek, String time, int duration, int spaces, Employee instructor) {
		super();
		this.id= id;
		this.name = name;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.duration = duration;
		this.spaces = spaces;
		this.instructor = instructor; 
	}

	public ClassesTypes getName() { 
		return name;
	}

	public void setName(ClassesTypes name) {
		this.name = name;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
