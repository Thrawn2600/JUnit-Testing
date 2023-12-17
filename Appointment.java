package com.projectone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Appointment {
	private final String id;
	private String appDate;
	private String appDescription;
	private int idLength = 10; 
	private int descLength = 50;
	
	
	//improvement - made the date time formatter static and reused it.
	private static final DateTimeFormatter DTForm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	//re ordered some stuff so that it checks all the conditions before updating anything
	
	public Appointment(String id, String date, String description) {
		LocalDate formattedDate;
		//first we check the id
		if (id == null || id.length() > idLength) {
			throw new IllegalArgumentException("Null or too long ID");
		}

		//then we check the date
		if (date == null) {
			throw new IllegalArgumentException("That date is null");
		}
		//then we check description
		if (description == null || description.length() > descLength) {
			throw new IllegalArgumentException("Null or to long description");
		}
		
		try {
			
			formattedDate = LocalDate.parse(date, DTForm);
		}
		
		catch (DateTimeParseException exception) {
			throw new IllegalArgumentException("Invalid Date Format should be yyyy-MM-dd", exception);
		}
		
		if (formattedDate.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("That date is in the past, in must be in the future");
		}
			
		//All of this now happens after all the logical statements to clean up the chances that something gets updated even with bad info somewhere else
		//Before it might have been possible set some of the details about the object but not others
		
		this.appDate = date;
		this.id = id;
		this.appDescription = description;

	}
	
	
	//Getters
	public String getId() {
		return id;
	}
	
	public String getAppDate() {
		return appDate;
	}
	
	public String getAppDescription() {
		return appDescription;
	}
	
	//Setters
	public void setAppDate(String date) {
		LocalDate formattedDate;
		if (date == null) {
			throw new IllegalArgumentException("That date is null");
		}
		
		try {
			formattedDate = LocalDate.parse(date, DTForm);
			
		}
		
		catch (DateTimeParseException exception) {
			throw new IllegalArgumentException("Invalid Date Format should be yyyy-MM-dd", exception);
		}
		
		if (formattedDate.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("That date is in the past, in must be in the future");
		}
			
		this.appDate = date;
		
	}
	//actually caught an error here that was submitted last time. I was checking if the id was null not the description. Fixed now.
	public void setAppDescription(String description) {
		
		if (description == null || description.length() > descLength) {
			throw new IllegalArgumentException("Null or to long description");
		}
		
		this.appDescription = description;
	}
}
