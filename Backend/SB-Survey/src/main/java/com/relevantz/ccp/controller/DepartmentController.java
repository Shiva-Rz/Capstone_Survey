package com.relevantz.ccp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relevantz.ccp.model.Department;
import com.relevantz.ccp.service.DepartmentService;

@RestController
@CrossOrigin("http://localhost:4200/")
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
	
	@GetMapping("/getdepartment/{regionId}")
	public List<Department> viewComplaintDetails(@PathVariable("regionId") long regionId){
	    return dtService.getDepartmentDetails(regionId);
		
	}
	
	@GetMapping("/department")
	public List<Department> viewAllDepartmentDetails(){
		return dtService.getAllDepartmentDetails();
	}

}
