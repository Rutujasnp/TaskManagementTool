package com.todo.TaskService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.TaskService.Entity.Task;
import com.todo.TaskService.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	// create task
	
	@PostMapping
	public Task createTask(@RequestBody Task task) {	
		taskService.createTask(task);
		return task;
	
	}
	

	// update task by task id
	
	@PutMapping("{id}")
	public Task updateTask(@RequestBody Task task, @PathVariable("id") Long id) {
		taskService.updateTaskById(id, task);
		return task;
	
	}
	
     // get task by task id
	
	@GetMapping("{id}")
	public Task getTaskId(@PathVariable("id") Long id) {
		
		Task task = taskService.getTaskById(id);
		return task;
		
		
	}
	
    // get task by userId
	
	@GetMapping("user/{userId}")
	public List<Task> getAllTask(@PathVariable("userId") Long userId) {
		
		List<Task> tasks = taskService.getAllTasksByUsrId(userId);
		return tasks;	
	}
	
	// delete task by task id
	
	@DeleteMapping("{id}")
	public void deleteTask(@PathVariable("id") Long id) {
		taskService.deleteTaskById(id);
	}

}
