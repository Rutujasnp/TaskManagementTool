package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.ResourceNotFoundException;
import com.project.model.Project;
import com.project.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository pr;

	@Override
	public List<Project> findAll() {
		return pr.findAll();
	}

	@Override
	public Project findByPid(long pid) {
		Project project = pr.findById(pid)
			.orElseThrow(() -> new ResourceNotFoundException("Project does not exist with given id: "+pid));
		return project;
	}

	

	@Override
	public Project createProject(Project project) {
		return pr.save(project);
	}

	@Override
	public int deleteByPid(long pid) {
		return pr.deleteByPid(pid);
	}

//	@Override
//	public Project updateProject(Project project) {
//		return pr.save(project);
//	}

	@Override
	public Project updateProject(long pid, Project newProject) {
		return pr.findById(pid).map(existingProject -> {
            existingProject.setPname(newProject.getPname());
            // Update other fields as necessary
            return pr.save(existingProject);
        }).orElseThrow(() -> new RuntimeException("Project not found"));
	}

	
	
}
