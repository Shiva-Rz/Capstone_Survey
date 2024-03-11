package com.survey.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.survey.bean.Project;
import com.survey.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectService ptService;
	
	@PostMapping("/project")
	public String performInsert(@RequestBody Project project) {
		ptService.insert(project);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/project")
	public String performUpdate(@RequestBody Project project) {
		ptService.update(project);	
		return "Record Updated";
	}
	
	@DeleteMapping("/project/{projectId}")
	public void performDelete(@PathVariable("projectId") long projectId) {
		ptService.delete(projectId);
	}
	
	@GetMapping("/project")
	public List<Project> viewAllProjectDetails(){
		return ptService.getAllProjectDetails();
	}
	
	@GetMapping("/getProject/{departmentId}")
	public List<Project> viewProjectByDepartment(@PathVariable("departmentId") long departmentId){
		return ptService.getAllDepartmentByProject(departmentId);
	}


}
