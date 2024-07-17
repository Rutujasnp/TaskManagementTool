package com.todo.UserService.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.todo.UserService.Entity.Users;
import com.todo.UserService.Exceptions.ResourceNotFoundException;
import com.todo.UserService.Service.UserService;
import com.todo.UserService.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	

	@GetMapping
	public ResponseEntity<List<Users>> findAllUsers() {
		return ResponseEntity.ok(userServiceImpl.findAllUsers()) ;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Users> findUserById(@PathVariable("id")  Long id) {
	return ResponseEntity.ok(userServiceImpl.findUserById(id));	 
			
	}

	@PostMapping("/saveUser")
	public ResponseEntity<Users> saveUser(@RequestBody Users user) {
		System.out.println("into controoller "+ user.getPassword());
		Users newUser=userServiceImpl.saveUser(user);
		System.out.println("after servie "+ user.getGmail() + user.getUser_name());
		return new ResponseEntity<Users>(newUser, HttpStatus.CREATED);
	}

	@PutMapping("/updateUser/{id}")
	public Users updateUser(@RequestBody Users user, @PathVariable Long id) {
		return userServiceImpl.updateUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userServiceImpl.deleteUser(id);;
	}

	
}
