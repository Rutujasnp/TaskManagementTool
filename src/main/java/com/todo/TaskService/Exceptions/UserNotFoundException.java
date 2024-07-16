package com.todo.TaskService.Exceptions;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7195750526629637817L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
