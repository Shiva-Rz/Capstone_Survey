package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Department;
import com.relevantz.ccp.repository.DepartmentRepo;

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

	public List<Department> getDepartmentDetails(long regionId) {
		Iterator<Department> it1 = dtRepo.findByRegionId(regionId).iterator();
		ArrayList<Department> departmentList = new ArrayList<>();
		while (it1.hasNext()) {
			departmentList.add(it1.next());
		}
		return departmentList;
	}

	public List<Department> getAllDepartmentDetails() {
		Iterator<Department> it = dtRepo.findAll().iterator();
		ArrayList<Department> list = new ArrayList<>();
		while (it.hasNext()) {
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
