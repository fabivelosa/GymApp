package com.ait.gym.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.gym.bean.Employee;
import com.ait.gym.bean.GymClass;
import com.ait.gym.utils.ClassesTypes;

class GymClassTest {

	private GymClass gymClass;
	private GymClass gymClasspersonal;

	@BeforeEach
	void setUp() throws Exception {
		Date dob = new Date();
		Employee personal = new Employee("Fabi", "Female", dob, "17, address - Athlone", "fabi@gmail", "083-123456",
				"fabi", "123", "Java is my favorite class.", true);
		gymClass = new GymClass(1, ClassesTypes.PILATES, DayOfWeek.MONDAY, "09:00", 50, 20);
		gymClasspersonal = new GymClass(2, ClassesTypes.ONE_ONE_SESSION, DayOfWeek.WEDNESDAY, "13:00", 50, 1, personal);

	}

	@Test
	public void testGymClassContructor() {
		assertEquals(1, gymClass.getId());
		assertEquals(ClassesTypes.PILATES, gymClass.getName());
		assertEquals(DayOfWeek.MONDAY, gymClass.getDayOfWeek());
		assertEquals("09:00", gymClass.getTime());
		assertEquals(50, gymClass.getDuration());
		assertEquals(20, gymClass.getSpaces());
	}

	@Test

	public void testGymClassContructorEmployee() {
		assertEquals(2, gymClasspersonal.getId());
		assertEquals(ClassesTypes.ONE_ONE_SESSION, gymClasspersonal.getName());
		assertEquals(DayOfWeek.WEDNESDAY, gymClasspersonal.getDayOfWeek());
		assertEquals("13:00", gymClasspersonal.getTime());
		assertEquals(50, gymClasspersonal.getDuration());
		assertEquals(1, gymClasspersonal.getSpaces());
	}
}
