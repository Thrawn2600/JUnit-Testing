package com.projectone;
import java.util.HashMap;
import java.util.Map;



public class TaskService {
	
	private Map<String, Task> TaskList;
	
	public TaskService() {
		this.TaskList = new HashMap<>();
	}

	public void  addNewTask(String taskId, String taskName, String taskDescription) {
		//Check to ensure that the ID is unique 
		if (TaskList.containsKey(taskId)) {
			throw new IllegalArgumentException("Id in Use");
		}
		
		Task NewTask = new Task(taskId, taskName, taskDescription);   //this was a much simpler method of doing it. I now see why the requirement was made to put the validation in the class... it's way more reusable. 
		
		TaskList.put(taskId, NewTask);
		
	}
	
	public void updateTask (String taskId, String taskName, String taskDescription) {
		//we check that the ID exists
		if(!TaskList.containsKey(taskId)) {
			throw new IllegalArgumentException ("Task Not Found");
		}
		//yank the task out of the list
		Task taskToUpdate = TaskList.get(taskId);
		
		//and update, if any of the data is bad the class with throw exceptions and not update
		taskToUpdate.setTaskName(taskName);
		
		taskToUpdate.setTaskDescription(taskDescription);
		
		
	}
	
	public void deleteTask(String taskId ) {
		
		
		if(!TaskList.containsKey(taskId)) {
			throw new IllegalArgumentException ("Task Not Found");
			
		}
		
		TaskList.remove(taskId);
		
		
	}
	
	public Task returnTask(String taskId) {

		if(!TaskList.containsKey(taskId)) {
			throw new IllegalArgumentException ("Task Not Found");
		}
		
		return TaskList.get(taskId);
	}
	
}
