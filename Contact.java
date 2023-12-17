package com.projectone;

public class Contact {

	private final String id;  //Final because it must not be changed after it is set. 
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	private int idLength = 10;
	private int firstNameLength = 10;
	private int lastNameLength  = 10;
	private int numberLength = 10;
	private int addressLength = 30;
	
	//Contact object
	public Contact(String id, String firstName, String lastName, String number, String address) {
		
		if (id == null || id.length() > idLength) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (firstName == null || firstName.length() > firstNameLength) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length() > lastNameLength) {
			throw new IllegalArgumentException("Invalid Last name");
		}
		if (number == null || number.length() != numberLength) {
			throw new IllegalArgumentException("Invalid Number Length");
		}
		if (address == null || address.length() > addressLength) {
			throw new IllegalArgumentException("Invalid Address Length");
		}
		
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}
	
	//getters
	public String getId() {
		return id;
		
	}

	public String getFirstName() {
		return firstName;
		
	}
	
	public String getLastName() {
		return lastName;
		
	}
	
	public String getNumber() {
		return number;
		
	}
	
	public String getAddress() {
		return address;
		
	}
	
	//setters
	
	public void setFirstName(String firstName) {
		
		if (firstName == null || firstName.length() > firstNameLength) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		
		if (lastName == null || lastName.length() > lastNameLength) {
			throw new IllegalArgumentException("Invalid Last name");
		}
		this.lastName = lastName;
	}
	
	public void setNumber(String number) {
		
		if (number == null || number.length() != numberLength) {
			throw new IllegalArgumentException("Invalid Number Length");
		}
		
		this.number = number;
	}
	
	public void setAddress(String address) {
		
		if (address == null || address.length() > addressLength) {
			throw new IllegalArgumentException("Invalid Address Length");
		}
		
		this.address = address;
	}

}
