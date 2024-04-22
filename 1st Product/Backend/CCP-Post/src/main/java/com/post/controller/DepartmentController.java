package com.post.controller;

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

import com.post.entity.DepartmentDTO;
import com.post.service.DepartmentService;


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
}