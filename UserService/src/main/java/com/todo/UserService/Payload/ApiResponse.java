package com.todo.UserService.Payload;

import org.springframework.http.HttpStatus;


import com.todo.UserService.Entity.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

	
	private  String message;
	private boolean success;
	private HttpStatus status;
	
	public ApiResponse(String message, boolean success) {
		this.message=message;
		this.success=success;
	}
	
	
}
