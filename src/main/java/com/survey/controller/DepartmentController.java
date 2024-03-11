package com.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.survey.bean.Comment;
import com.survey.bean.Department;
import com.survey.service.CommentService;
import com.survey.service.DepartmentService;

public class DepartmentController {
	

	@Autowired
	 DepartmentService dtService;
	
	@PostMapping("/department")
	public String performInsert(@RequestBody Department department) {
		dtService.insert(department);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/department")
	public String performUpdate(@RequestBody Department department) {
		dtService.update(department);	
		return "Record Updated";
	}
	
	@DeleteMapping("/department/{departmentId}")
	public void performDelete(@PathVariable("departmentId") long departmentId) {
		dtService.delete(departmentId);
	}
	
	@GetMapping("/department")
	public List<Department> viewAllDepartmentDetails(){
		return dtService.getAllDepartmentDetails();
	}
	
//	@GetMapping("/departmentdetail")
//	public List<Department> viewDetails(){
//		return dtservice.DepartmentDetails();
//	}

}
