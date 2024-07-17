package com.todo.UserService.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name="users")
public class Users {

	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(String user_name, String password, String gmail, String role, Set<Roles> roles) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.gmail = gmail;
		this.role = role;
		this.roles = roles;
	}


	public Users(Long user_id, String user_name, String password, String gmail, String role, Set<Roles> roles) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.gmail = gmail;
		this.role = role;
		this.roles = roles;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Set<Roles> getRoles() {
		return roles;
	}


	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}


	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	private String user_name;
	private String password;
	private String gmail;
	private String role;
	
	
	@ManyToMany
    @JoinTable(
        name = "user_roles",  //join table
        joinColumns = @JoinColumn(name = "user_id"),  // column in user_roles table that references users table
        inverseJoinColumns = @JoinColumn(name = "role_id") ) // column in user_roles table that references roles table
        private Set<Roles> roles = new HashSet<>();
	
	 
}
