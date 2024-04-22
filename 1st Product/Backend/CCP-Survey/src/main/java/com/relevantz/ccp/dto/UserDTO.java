package com.relevantz.ccp.dto;
 
import java.util.ArrayList;

 
import java.util.List;
 
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
 
import jakarta.persistence.Column;
 
import jakarta.persistence.Entity;
 
import jakarta.persistence.GeneratedValue;
 
import jakarta.persistence.GenerationType;
 
import jakarta.persistence.Id;
 
import jakarta.persistence.JoinColumn;
 
import jakarta.persistence.ManyToMany;
 
import jakarta.persistence.ManyToOne;
 
import jakarta.persistence.OneToMany;
 
import jakarta.persistence.Table;
 
public class UserDTO {
 
	private Long userId;
 
	private String userFirstName;
 
	private String userLastName;
 
	private String userEmailId;
 
	private String userType;
 
	private Long userMobileNumber;
 
	private long department;
	private String departmentName;

 
	private long region;
	private String regionName;
 
// private List<Project> project = new ArrayList<Project>();
 
	private List<Long> project = new ArrayList<>();

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Long userId, String userFirstName, String userLastName, String userEmailId, String userType,
			Long userMobileNumber, long department, String departmentName, long region, String regionName,
			List<Long> project) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmailId = userEmailId;
		this.userType = userType;
		this.userMobileNumber = userMobileNumber;
		this.department = department;
		this.departmentName = departmentName;
		this.region = region;
		this.regionName = regionName;
		this.project = project;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getUserMobileNumber() {
		return userMobileNumber;
	}

	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
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

	public List<Long> getProject() {
		return project;
	}

	public void setProject(List<Long> project) {
		this.project = project;
	}
 
	 
}