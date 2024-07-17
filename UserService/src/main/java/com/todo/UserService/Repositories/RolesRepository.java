package com.todo.UserService.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.UserService.Entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {

}
