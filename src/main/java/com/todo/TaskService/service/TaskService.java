package com.todo.TaskService.service;

import java.util.List;

import com.todo.TaskService.Entity.Task;

public interface TaskService {
	
	public Task getTaskById(Long id);
	
	public List<Task> getAllTasksByUsrId(Long userId);
	
	public Task createTask(Task task);
	
	public Task updateTaskById(Long Id, Task task);
	
	public void deleteTaskById(Long Id);

}
