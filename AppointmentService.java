package com.projectone;
import java.util.HashMap;
import java.util.Map;


public class AppointmentService {
	
	private Map<String, Appointment> AppointmentList;
	
	public AppointmentService() {
		
		this.AppointmentList = new HashMap<>();
	}
	
	
	public void addNewAppointment(String id, String date, String description) {
		
		if (AppointmentList.containsKey(id)) {
			throw new IllegalArgumentException ("That ID is already in use");
		}
		
		Appointment validAppointment = new Appointment(id, date, description);
		
		AppointmentList.put(id, validAppointment);
		
	}
	
	public void updateAppointmentDate(String id, String date) {
		
		if (!AppointmentList.containsKey(id)) {
			throw new IllegalArgumentException ("No appointment with that ID found");
		}
		
		Appointment appointmentToUpdate = AppointmentList.get(id);
		
		appointmentToUpdate.setAppDate(date);
		
	}
	
	public void updateAppointmentDesc(String id, String description) {
		
		if (!AppointmentList.containsKey(id)) {
			throw new IllegalArgumentException ("No appointment with that ID found");
		}
		
		Appointment appointmentToUpdate = AppointmentList.get(id);
		
		appointmentToUpdate.setAppDescription(description);
		
	}
	
	public void deleteApointment(String id) {
		
		if (!AppointmentList.containsKey(id)) {
			throw new IllegalArgumentException("No appointment with that ID found");
		}
		
		AppointmentList.remove(id);
	}
	
	public Appointment returnAppointment(String id) {
		
		if (!AppointmentList.containsKey(id)) {
			throw new IllegalArgumentException ("No appointment with that ID found");
		}
		
		Appointment appToReturn = AppointmentList.get(id);
		
		return appToReturn;
	}
}
