package com.todo.TaskService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.todo.TaskService.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	@Query("SELECT t FROM Task t WHERE t.userId = :userId")
	public List<Task> findByUserId(Long userId);

}
