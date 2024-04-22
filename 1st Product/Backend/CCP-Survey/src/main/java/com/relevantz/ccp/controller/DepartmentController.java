package com.relevantz.ccp.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.relevantz.ccp.dto.DepartmentDTO;
import com.relevantz.ccp.model.Department;
import com.relevantz.ccp.service.DepartmentService;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:4200/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/insertDepartments")
    public void performInsert(@RequestBody DepartmentDTO departmentdto) {
        departmentService.saveOrUpdateDepartment(departmentdto);
    }
    @PutMapping("/updateDepartments")
    public void performUpdate(@RequestBody DepartmentDTO departmentdto) {
        departmentService.saveOrUpdateDepartment(departmentdto);
    }
    @DeleteMapping("/deleteDepartments/{departmentId}")
    public void performDelete(@PathVariable ("departmentId")Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }
    @GetMapping("/findAllDepartments")
    public List<DepartmentDTO> viewAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @GetMapping("/ViewDepartments/{departmentId}")
    public List<DepartmentDTO> viewDepartments(@PathVariable("departmentId")Long departmentId) {
        return departmentService.getDepartment( departmentId);
    }
    @GetMapping("/getDepartment/{regionId}")
    public List<DepartmentDTO> getDepartments(@PathVariable("regionId")Long regionId) {
        return departmentService.getParticular( regionId);
    }
    
    @GetMapping("/getdepartment/{regionId}")
	public List<Department> viewComplaintDetails(@PathVariable("regionId") long regionId){
	    return departmentService.getDepartmentDetails(regionId);
		
	}
}