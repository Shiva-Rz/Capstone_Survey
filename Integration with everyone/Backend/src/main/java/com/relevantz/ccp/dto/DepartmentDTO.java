package com.relevantz.ccp.dto;
import java.util.List;

import com.relevantz.ccp.model.Project;
import com.relevantz.ccp.model.User;


public class DepartmentDTO {
    private Long departmentId;

    private String departmentName;

    private long region;
    private String regionName;

    private List<User> users;

    private List<Project> projects;
 
 
	public DepartmentDTO() {
		super();
	}
 
 
	public DepartmentDTO(Long departmentId, String departmentName, long region, String regionName, List<User> users,
			List<Project> projects) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.region = region;
		this.regionName = regionName;
		this.users = users;
		this.projects = projects;
	}
 
 
	public Long getDepartmentId() {
		return departmentId;
	}
 
 
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
 
 
	public String getDepartmentName() {
		return departmentName;
	}
 
 
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
 
 
	public long getRegion() {
		return region;
	}
 
 
	public void setRegion(long region) {
		this.region = region;
	}
 
 
	public String getRegionName() {
		return regionName;
	}
 
 
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
 
 
	public List<User> getUsers() {
		return users;
	}
 
 
	public void setUsers(List<User> users) {
		this.users = users;
	}
 
 
	public List<Project> getProjects() {
		return projects;
	}
 
 
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


}