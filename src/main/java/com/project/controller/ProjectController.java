package com.project.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Project;
import com.project.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService ps;
	
	@GetMapping(path = "/")
	public List<Project> home(){
		return ps.findAll();
	}
	
	@GetMapping(path = "/findbypid/{id}")
	public Project p1(@PathVariable long id) {
		return ps.findByPid(id);
	}
	
	
	@PostMapping(path = "/addproject")
	public Project p2(@RequestBody Project project) {
		return ps.createProject(project);
	}
	
	@DeleteMapping(path = "/deleteproject/{id}")
	public long p3(@PathVariable long id) {
		return ps.deleteByPid(id);
	}
	
	@PutMapping(path = "/updateproject/{id}")
	public ResponseEntity<Project> p4(@PathVariable long id, @RequestBody Project project) {
		Project updatedProject = ps.updateProject(id, project);
		
		return ResponseEntity.ok(updatedProject);
		
	}
}
