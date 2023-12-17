package com.projectone;
import java.util.HashMap;
import java.util.Map;

import com.projectone.Contact;



public class ContactService {

	private Map<String, Contact> ContactList; 
	
	public ContactService() {
		this.ContactList = new HashMap<>();
	}
	
	public void addNewContact(String id, String firstName, String lastName, String number, String address) {
		
		if (ContactList.containsKey(id)) {
			throw new IllegalArgumentException("Key Already Found");
		}
		
		Contact validContact = new Contact (id, firstName, lastName, number, address);
		
		ContactList.put(id, validContact);

	}
	//updated to remove !=True from if statements
	public void updateContact (String id, String firstName, String lastName, String number, String address) {
		
		if(!ContactList.containsKey(id)) {
			throw new IllegalArgumentException("Key Not Found");
		}
		//get Contact
		Contact contactToUpdate = ContactList.get(id);
		
		
		//update via setters
		contactToUpdate.setFirstName(firstName);
		contactToUpdate.setLastName(lastName);
		contactToUpdate.setLastName(lastName);
		contactToUpdate.setNumber(number);
		contactToUpdate.setAddress(address);

		
	}
	
	//improvements - removed !=True statements
	
	public void deleteContact(String id) {
		
		//check the key exists
		if(!ContactList.containsKey(id)) { 
			throw new IllegalArgumentException("Key Not Found");
		}
		// then remove the contact
		ContactList.remove(id);
		

	}
	
	
	public Contact returnContact(String id) {

		//check the key exists
		if(!ContactList.containsKey(id)) { 
			throw new IllegalArgumentException("Key Not Found");
		}
		
		Contact contactToReturn = ContactList.get(id);
		
		return contactToReturn;
		
	}

}
