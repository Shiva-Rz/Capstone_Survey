package com.rts.ccp.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Department;
import com.rts.ccp.bean.Project;
import com.rts.ccp.dto.DepartmentDTO;
import com.rts.ccp.dto.ProjectDTO;
import com.rts.ccp.repository.DepartmentRepo;
import com.rts.ccp.repository.ProjectRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
@Service
public class ProjectService {
 
	@Autowired
	private ProjectRepo projectRepo;
	@Autowired
	private DepartmentRepo departmentRepo;
 
	@Autowired
	private Project project;
	@Autowired
	private Department department;
 
	public boolean saveOrUpdateProject(ProjectDTO projectdto) {
		project.setProjectId(projectdto.getProjectId());
		project.setProjectName(projectdto.getProjectName());
		project.setStartDate(projectdto.getStartDate());
		project.setEndDate(projectdto.getEndDate());
		department = departmentRepo.findById(projectdto.getDepartment()).get();
		project.setDepartment(department);
 
		projectRepo.save(project);
		return true;
	}
 
	public boolean deleteProjectById(Long projectId) {
		projectRepo.deleteById(projectId);
		return true;
	}
 
	public List<ProjectDTO> getAllProjects() {
 
		Iterator<Project> iterator = projectRepo.findAll().iterator();
		List<ProjectDTO> proList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			Project project = iterator.next();
 
			ProjectDTO projectdto = new ProjectDTO();
			projectdto.setProjectId(project.getProjectId());
			projectdto.setProjectName(project.getProjectName());
			projectdto.setStartDate(project.getStartDate());
			projectdto.setEndDate(project.getEndDate());
			projectdto.setDepartment(project.getDepartment().getDepartmentId());
			projectdto.setDepartmentName(project.getDepartment().getDepartmentName());
			proList.add(projectdto);
 
		}
		return proList;
	}
 
	public List<ProjectDTO> getProject(long projectId) {
		Project project = projectRepo.findById(projectId).get();
		ArrayList<ProjectDTO> proList = new ArrayList<>();
		ProjectDTO projectdto = new ProjectDTO();
		projectdto.setProjectId(project.getProjectId());
		projectdto.setProjectName(project.getProjectName());
		projectdto.setStartDate(project.getStartDate());
		projectdto.setEndDate(project.getEndDate());
		projectdto.setDepartment(project.getDepartment().getDepartmentId());
		projectdto.setDepartmentName(project.getDepartment().getDepartmentName());
		proList.add(projectdto);
		return proList;
	}
	public List<ProjectDTO> getParticular(long departmentId) {
 
		Iterator<Project> iterator = projectRepo.findByProjectId(departmentId).iterator();
		List<ProjectDTO> projectList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			Project project = iterator.next();
			ProjectDTO projectdto = new ProjectDTO();
			projectdto.setProjectId(project.getProjectId());
			projectdto.setProjectName(project.getProjectName());
			projectdto.setStartDate(project.getStartDate());
			projectdto.setEndDate(project.getEndDate());
			projectdto.setDepartment(project.getDepartment().getDepartmentId());
			projectdto.setDepartmentName(project.getDepartment().getDepartmentName());

 
			projectList.add(projectdto);
		}
		return projectList;
	}

}