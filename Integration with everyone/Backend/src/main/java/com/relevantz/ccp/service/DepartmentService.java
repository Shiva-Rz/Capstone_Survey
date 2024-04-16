package com.relevantz.ccp.service;
 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.DepartmentDTO;
import com.relevantz.ccp.model.Department;
import com.relevantz.ccp.model.Region;
import com.relevantz.ccp.repository.DepartmentRepo;
import com.relevantz.ccp.repository.RegionRepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
 
@Service
public class DepartmentService {
 
	@Autowired
	private DepartmentRepo departmentRepo;
 
	@Autowired
	private  Department department;
 
	@Autowired
	private Region region;
 
	@Autowired
	private RegionRepo regdao;
 
	public boolean saveOrUpdateDepartment(DepartmentDTO departmentdto) {
 
		department.setDepartmentId(departmentdto.getDepartmentId());
		department.setDepartmentName(departmentdto.getDepartmentName());
		region = regdao.findById(departmentdto.getRegion()).get();
		department.setRegion(region);
 
		departmentRepo.save(department);
		return true;
	}
 
	public boolean deleteDepartmentById(Long departmentId) {
		departmentRepo.deleteById(departmentId);
		return true;
	}
 
//    public List<Department> getAllDepartments() {
//        return departmentRepo.findAll();
//    }
 
	public List<DepartmentDTO> getAllDepartments() {
 
		Iterator<Department> iterator = departmentRepo.findAll().iterator();
		List<DepartmentDTO> userList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			Department department = iterator.next();
			DepartmentDTO departmentdto = new DepartmentDTO();
			departmentdto.setDepartmentId(department.getDepartmentId());
			departmentdto.setDepartmentName(department.getDepartmentName());
			departmentdto.setRegion(department.getRegion().getRegionId());
			departmentdto.setRegionName(department.getRegion().getRegionName());
 
			userList.add(departmentdto);
		}
		return userList;
	}
 
	public List<DepartmentDTO> getDepartment(Long departmentId) {
		Department department = departmentRepo.findById(departmentId).get();
 
		ArrayList<DepartmentDTO> depList = new ArrayList<>();
		DepartmentDTO departmentdto=new DepartmentDTO();
		departmentdto.setDepartmentId(department.getDepartmentId());
		departmentdto.setDepartmentName(department.getDepartmentName());
		departmentdto.setRegion(department.getRegion().getRegionId());
		departmentdto.setRegionName(department.getRegion().getRegionName());
		depList.add(departmentdto);
 
		return depList;
	}

	public List<DepartmentDTO> getParticular(long regionId) {
 
		Iterator<Department> iterator = departmentRepo.findByRegionId(regionId).iterator();
		List<DepartmentDTO> depList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			Department department = iterator.next();
			DepartmentDTO departmentdto = new DepartmentDTO();
			departmentdto.setDepartmentId(department.getDepartmentId());
			departmentdto.setDepartmentName(department.getDepartmentName());
			departmentdto.setRegion(department.getRegion().getRegionId());
			departmentdto.setRegionName(department.getRegion().getRegionName());
 
			depList.add(departmentdto);
		}
		return depList;
	}
	
	public List<Department> getDepartmentDetails(long regionId) {
		Iterator<Department> it1 = departmentRepo.findByRegionId(regionId).iterator();
		ArrayList<Department> departmentList = new ArrayList<>();
		while (it1.hasNext()) {
			departmentList.add(it1.next());
		}
		return departmentList;
	}

 
}