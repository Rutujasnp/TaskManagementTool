package com.todo.TaskService.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	
	@jakarta.persistence.Id
	@GeneratedValue
	private Long Id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Long userId;

	public Task(String name, String description, Long userId) {
		super();
		this.name = name;
		this.description = description;
		this.userId = userId;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	


}
