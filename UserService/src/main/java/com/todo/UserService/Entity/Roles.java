package com.todo.UserService.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")

public class Roles {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long role_id;
	private String role_name;

	@ManyToMany(mappedBy = "roles")
    private Set<Users> users = new HashSet<>();
}
