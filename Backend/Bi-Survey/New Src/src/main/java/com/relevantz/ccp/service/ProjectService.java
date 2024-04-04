package com.relevantz.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Project;
import com.relevantz.ccp.repository.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	ProjectRepo ptRepo;
	
	public boolean insert(Project project) {
		ptRepo.save(project);
		return true;
   }
	
	public boolean update(Project project) {
		ptRepo.save(project);
		return true;
	}
	
	public boolean delete(long projectId) {
		ptRepo.deleteById(projectId);
		return true;
	}
	
	public List<Project> getAllProjectDetails(){
		Iterator<Project> it=ptRepo.findAll().iterator();
		ArrayList<Project> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public List<Project> getAllDepartmentByProject(long departmentId){
		Iterator<Project> it=ptRepo.findProjectByDepartment(departmentId).iterator();
		ArrayList<Project> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}	


}
