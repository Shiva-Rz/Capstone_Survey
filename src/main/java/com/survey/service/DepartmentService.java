package com.survey.service;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.bean.Department;
import com.survey.repo.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
    DepartmentRepo dtRepo;
	
	public boolean insert(Department department) {
		dtRepo.save(department);
		return true;
   }
	
	public boolean update(Department department) {
		dtRepo.save(department);
		return true;
	}
	
	public boolean delete(long departmentId) {
		dtRepo.deleteById(departmentId);
		return true;
	}
		
	public List<Department> getAllDepartmentDetails(){
		Iterator<Department> it=dtRepo.findAll().iterator();
		ArrayList<Department> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}	
	
	
//	public List<Department> DepartmentDetails(){
//		Iterator<Department> it=dtrepo.getDepartment().iterator();
//		ArrayList<Department> list=new ArrayList<>();
//		while(it.hasNext()) {
//			list.add(it.next());
//		}
//		return list;
//	}	



}
