package com.ait.gym.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PlannerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String MemberName;
	private String[] mondaySession;
	private String[] tuesdaySession;
	private String[] wednesdaySession;
	private String[] thursdaySession;
	private String[] fridaySession;

	// Monday
	public String[] getMondaySession() {
		return mondaySession;
	}

	public void setMondaySession(String[] mondaySession) {
		this.mondaySession = mondaySession;
	}

	public String getMondaySessionInString() {
		return Arrays.toString(mondaySession);
	}

	// Tuesday
	public String[] getTuesdaySession() {
		return tuesdaySession;
	}

	public void setTuesdaySession(String[] tuesdaySession) {
		this.tuesdaySession = tuesdaySession;
	}

	public String getTuesdaySessionInString() {
		return Arrays.toString(tuesdaySession) + "Cooldown";
	}

	// Wednesday
	public String[] getWednesdaySession() {
		return wednesdaySession;
	}

	public void setWednesdaySession(String[] wednesdaySession) {
		this.wednesdaySession = wednesdaySession;
	}

	public String getWednesdaySessionInString() {
		return Arrays.toString(wednesdaySession) + "Cooldown";
	}

	// Thursday
	public String[] getThursdaySession() {
		return thursdaySession;
	}

	public void setThursdaySession(String[] thursdaySession) {
		this.thursdaySession = thursdaySession;
	}

	public String getThursdaySessionInString() {
		return Arrays.toString(thursdaySession) + "Cooldown";
	}

	// Friday
	public String[] getFridaySession() {
		return fridaySession;
	}

	public void setFridaySession(String[] fridaySession) {
		this.fridaySession = fridaySession;
	}

	public String getFridaySessionInString() {
		return Arrays.toString(fridaySession) + "Cooldown";
	}

	private static Map<String, Object> mondaySessionValue;
	{
		mondaySessionValue = new LinkedHashMap<String, Object>();

		mondaySessionValue.put("Day one passive stretching", "5 Mins of passive stretching");
		mondaySessionValue.put("Day one isometric stretching", "5 Mins of isometric stretching");
		mondaySessionValue.put("Day one ballistic stretching", "5 Mins of ballistic stretching");// label, value
		mondaySessionValue.put("Day one rowing", "20 Mins of rowing with break halfway through");
		mondaySessionValue.put("Day one cycling", "20 Mins of Cycling with break halfway through");
		mondaySessionValue.put("Day one running", "20 Mins of Running with break halfway through");
		mondaySessionValue.put("Day one squats", "10 sets of squats by 3 times");
		mondaySessionValue.put("Day one jumping jacks", "15 jumping jacks by 2 times");
		mondaySessionValue.put("Day one muscle training Back", "15 4kg Kettlebell Swings ");
		mondaySessionValue.put("Day one muscle training Arms", "25 push up times 2");
		mondaySessionValue.put("Day one muscle training Legs", "10 Lunges");
		mondaySessionValue.put("Day one rest", "rest day take it easy");
	}

	public Map<String, Object> getMondaySessionValue() {
		return mondaySessionValue;
	}

	private static Map<String, Object> tuesdaySessionValue;
	{
		tuesdaySessionValue = new LinkedHashMap<String, Object>();

		tuesdaySessionValue.put("Day two passive stretching", "5 Mins of passive stretching");
		tuesdaySessionValue.put("Day two isometric stretching", "5 Mins of isometric stretching");
		tuesdaySessionValue.put("Day two ballistic stretching", "5 Mins of ballistic stretching");// label, value
		tuesdaySessionValue.put("Day two rowing", "20 Mins of rowing with break halfway through");
		tuesdaySessionValue.put("Day two cycling", "20 Mins of Cycling with break halfway through");
		tuesdaySessionValue.put("Day two running", "20 Mins of Running with break halfway through");
		tuesdaySessionValue.put("Day two squats", "10 sets of squats by 3 times");
		tuesdaySessionValue.put("Day two jumping jacks", "15 jumping jacks by 2 times");
		tuesdaySessionValue.put("Day two muscle training Back", "15 4kg Kettlebell Swings ");
		tuesdaySessionValue.put("Day two muscle training Arms", "25 push up times 2");
		tuesdaySessionValue.put("Day two muscle training Legs", "10 Lunges");
		tuesdaySessionValue.put("Day two rest", "rest day take it easy");
	}

	public Map<String, Object> getTuesdaySessionValue() {
		return tuesdaySessionValue;
	}

	private static Map<String, Object> wednesdaySessionValue;
	{
		wednesdaySessionValue = new LinkedHashMap<String, Object>();

		wednesdaySessionValue.put("Day three passive stretching", "5 Mins of passive stretching");
		wednesdaySessionValue.put("Day three isometric stretching", "5 Mins of isometric stretching");
		wednesdaySessionValue.put("Day three ballistic stretching", "5 Mins of ballistic stretching");// label, value
		wednesdaySessionValue.put("Day three rowing", "20 Mins of rowing with break halfway through");
		wednesdaySessionValue.put("Day three cycling", "20 Mins of Cycling with break halfway through");
		wednesdaySessionValue.put("Day three running", "20 Mins of Running with break halfway through");
		wednesdaySessionValue.put("Day three squats", "10 sets of squats by 3 times");
		wednesdaySessionValue.put("Day three jumping jacks", "15 jumping jacks by 2 times");
		wednesdaySessionValue.put("Day three muscle training Back", "15 4kg Kettlebell Swings ");
		wednesdaySessionValue.put("Day three muscle training Arms", "25 push up times 2");
		wednesdaySessionValue.put("Day three muscle training Legs", "10 Lunges");
		wednesdaySessionValue.put("Day three rest", "rest day take it easy");
	}

	public Map<String, Object> getWednesdaySessionValue() {
		return wednesdaySessionValue;
	}

	private static Map<String, Object> thursdaySessionValue;
	{
		thursdaySessionValue = new LinkedHashMap<String, Object>();

		thursdaySessionValue.put("Day four passive stretching", "5 Mins of passive stretching");
		thursdaySessionValue.put("Day four isometric stretching", "5 Mins of isometric stretching");
		thursdaySessionValue.put("Day four ballistic stretching", "5 Mins of ballistic stretching");// label, value
		thursdaySessionValue.put("Day four rowing", "20 Mins of rowing with break halfway through");
		thursdaySessionValue.put("Day four cycling", "20 Mins of Cycling with break halfway through");
		thursdaySessionValue.put("Day four running", "20 Mins of Running with break halfway through");
		thursdaySessionValue.put("Day four squats", "10 sets of squats by 3 times");
		thursdaySessionValue.put("Day four jumping jacks", "15 jumping jacks by 2 times");
		thursdaySessionValue.put("Day four muscle training Back", "15 4kg Kettlebell Swings ");
		thursdaySessionValue.put("Day four muscle training Arms", "25 push up times 2");
		thursdaySessionValue.put("Day four muscle training Legs", "10 Lunges");
		thursdaySessionValue.put("Day four rest", "rest day take it easy");
	}

	public Map<String, Object> getThursdaySessionValue() {
		return thursdaySessionValue;
	}

	private static Map<String, Object> fridaySessionValue;
	{
		fridaySessionValue = new LinkedHashMap<String, Object>();

		fridaySessionValue.put("Day five passive stretching", "5 Mins of passive stretching");
		fridaySessionValue.put("Day five isometric stretching", "5 Mins of isometric stretching");
		fridaySessionValue.put("Day five ballistic stretching", "5 Mins of ballistic stretching");// label, value
		fridaySessionValue.put("Day five rowing", "20 Mins of rowing with break halfway through");
		fridaySessionValue.put("Day five cycling", "20 Mins of Cycling with break halfway through");
		fridaySessionValue.put("Day five running", "20 Mins of Running with break halfway through");
		fridaySessionValue.put("Day five squats", "10 sets of squats by 3 times");
		fridaySessionValue.put("Day five jumping jacks", "15 jumping jacks by 2 times");
		fridaySessionValue.put("Day five muscle training Back", "15 4kg Kettlebell Swings ");
		fridaySessionValue.put("Day five muscle training Arms", "25 push up times 2");
		fridaySessionValue.put("Day five muscle training Legs", "10 Lunges");
		fridaySessionValue.put("Day five rest", "rest day take it easy");
	}

	public Map<String, Object> getFridaySessionValue() {
		return fridaySessionValue;
	}

	public String getMemberName() {
		return MemberName;
	}

	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
//	/*
//	public void printToDesktop() throws IOException {
//		String userHomeFolder = System.getProperty("user.home");
//		File textFile = new File(userHomeFolder, "Plan.txt");
//		BufferedWriter out = new BufferedWriter(new FileWriter(textFile));
//		try {
//			
//		} finally {
//			out.close();
//		}*/

//	}

}
