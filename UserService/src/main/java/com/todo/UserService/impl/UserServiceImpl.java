package com.todo.UserService.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.todo.UserService.Entity.Users;
import com.todo.UserService.Exceptions.ResourceNotFoundException;
import com.todo.UserService.Repositories.UserRepository;
import com.todo.UserService.Service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository=userRepository;
	}

	@Override
	public List<Users> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Users findUserById(Long id) {
		return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with id"+id+"doesn't exist!") );
	}

	@Override
	public Users saveUser(Users user) {
		return userRepository.save(user);
		
	}

	@Override
	public Users updateUser(Users user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);;
	}

}
