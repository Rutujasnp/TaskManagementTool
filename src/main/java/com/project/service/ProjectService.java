package com.project.service;

import java.util.List;

import com.project.model.Project;

public interface ProjectService {

	public List<Project> findAll();
	
	public Project findByPid(long pid);
	
	public Project createProject(Project project);
	
	public int deleteByPid(long pid);

	public Project updateProject(long pid,Project project);
	
}
