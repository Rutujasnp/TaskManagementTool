package com.todo.TaskService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.TaskService.Entity.Task;
import com.todo.TaskService.Exceptions.UserNotFoundException;
import com.todo.TaskService.Repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;

	@Override
	public Task getTaskById(Long id) {
		Optional<Task> taskOp =	taskRepo.findById(id);
		if(taskOp.isEmpty()) {
			throw new UserNotFoundException("User not found with id "+id);
		}
		return taskOp.get();
	}

	@Override
	public List<Task> getAllTasksByUsrId(Long userId) {
		List<Task> tasks = new ArrayList<Task>();
		tasks = taskRepo.findByUserId(userId);
		return tasks;
	}

	@Override
	public Task createTask(Task task) {
		taskRepo.save(task);
		return task;
	}

	@Override
	public Task updateTaskById(Long id, Task task) {
		Optional<Task> oldTaskOp = taskRepo.findById(id);
		if(oldTaskOp.isEmpty()) {
			throw new UserNotFoundException("User Not Found with Id "+id);
		}
		Task oldTask = oldTaskOp.get();
		if(oldTask !=null) {
			if(!oldTask.getName().equals(task.getName())) {
				oldTask.setName(task.getName());
			}
			if(!oldTask.getDescription().equals(task.getDescription())) {
				oldTask.setDescription(task.getDescription());
			}
			if(!oldTask.getUserId().equals(task.getUserId())) {
				oldTask.setUserId(task.getUserId());
			}
			taskRepo.save(oldTask);
		}
		
		return oldTask;
	}

	@Override
	public void deleteTaskById(Long id) {
		taskRepo.deleteById(id);
	}

}
