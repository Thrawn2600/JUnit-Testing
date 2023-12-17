package com.projectone;

public class Task {
	private final String taskId;  //Final because it must not be changed after it is set. 
	private String taskName;
	private String taskDescription;
	
	private int taskIdLength = 10;
	private int taskNameLength = 20;
	private int taskDescriptionLength = 50;
	
	//Task object
	public Task(String taskId, String taskName, String taskDescription) {
		if ( taskId == null || taskId.length()> taskIdLength ) {   //this time I did the validation in the class... 
			throw new IllegalArgumentException("Invalid ID");
		}
 		
		
		if (taskName == null || taskName.length() > taskNameLength  ) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if ( taskDescription == null || taskDescription.length() > taskDescriptionLength ) {
			throw new IllegalArgumentException("Invalid Description");
		}
		else {
		this.taskId = taskId;	
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		}
		
	}
	
	//getters
	public String getId() {
		return taskId;
		
	}

	public String getTaskName() {
		return taskName;
		
	}
	
	public String getTaskDescription() {
		return taskDescription;
		
	}
	

	//setters
	
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > taskNameLength ) {   //have to make sure they can't be updated later with bad info
			throw new IllegalArgumentException("Invalid Name");
		}
		
		this.taskName = taskName;
	}
	
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > taskDescriptionLength ) {  //have to make sure they can't be updated later with bad info
			throw new IllegalArgumentException("Invalid Description");
		}
	
		this.taskDescription = taskDescription;
	}

}
