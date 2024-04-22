package com.rts.ccp.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.rts.ccp.bean.User;
 

public class ProjectDTO {
 
    private Long projectId;
    private String projectName;

    private Date startDate;

    private Date endDate;

    private long department;
    String departmentName;
 
	public ProjectDTO() {
		super();
	}
 
	public ProjectDTO(Long projectId, String projectName, Date startDate, Date endDate, long department,
			String departmentName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.department = department;
		this.departmentName = departmentName;
	}
 
	public Long getProjectId() {
		return projectId;
	}
 
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
 
	public String getProjectName() {
		return projectName;
	}
 
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
 
	public Date getStartDate() {
		return startDate;
	}
 
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
 
	public Date getEndDate() {
		return endDate;
	}
 
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
 
	public long getDepartment() {
		return department;
	}
 
	public void setDepartment(long department) {
		this.department = department;
	}
 
	public String getDepartmentName() {
		return departmentName;
	}
 
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}





}