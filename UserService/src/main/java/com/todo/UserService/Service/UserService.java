package com.todo.UserService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.todo.UserService.Entity.Users;

public interface UserService {

	public List<Users> findAllUsers();
	public Users findUserById(Long id);
	public Users saveUser(Users user);
	public Users updateUser(Users user);
	public void deleteUser(Long id);	
}
