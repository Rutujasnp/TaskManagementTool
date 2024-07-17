package com.todo.UserService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.UserService.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
