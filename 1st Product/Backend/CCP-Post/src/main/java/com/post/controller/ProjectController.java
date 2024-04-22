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

import com.post.entity.ProjectDTO;
import com.post.service.ProjectService;
@RestController
@CrossOrigin("http://localhost:4200/")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/insertProjects")
    public void performInsert(@RequestBody ProjectDTO projectdto) {
        projectService.saveOrUpdateProject(projectdto);
    }
    @PutMapping("/updateProjects")
    public void performUpdate(@RequestBody ProjectDTO projectdto ) {
        projectService.saveOrUpdateProject(projectdto);
    }
    @DeleteMapping("/deleteProjects/{projectId}")
    public void performDelete(@PathVariable ("projectId") Long projectId) {
        projectService.deleteProjectById(projectId);
    }
    @GetMapping("/findAllProjects")
    public List<ProjectDTO> viewAllProjects() {
        return projectService.getAllProjects();
    }
    @GetMapping("/viewProjects/{projectId}")
    public List<ProjectDTO> viewAllProjects(@PathVariable ("projectId")Long projectId) {
        return projectService.getProject(projectId);
    }
    @GetMapping("/getProject/{departmentId}")
    public List<ProjectDTO> getProjects(@PathVariable("departmentId")Long departmentId) {
        return projectService.getParticular( departmentId);
    }
}
