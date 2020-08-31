package com.ait.gym.utils;

public enum ClassesTypes {
	
	PILATES(1,"Pilates"),YOGA(2,"Yoga"),TAI_CHI(3,"Tai-Chi"),ONE_ONE_SESSION(4,"1-1 Session"),MINDFULLNESS(5,"Mindfullness"),CIRCUIT(6,"Circuits");
	private final int classCode;
	private final String value;
	

	private ClassesTypes(int classCode,String value) {
	        this.classCode = classCode; 
	        this.value = value;
	        
	  }
	
	 public int getClassCode() {
	        return this.classCode;
	 }

	 public String getValue() {
	        return this.value;
	 }
	 
}
