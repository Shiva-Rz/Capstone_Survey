package com.rts.ccp.dto;
 
import org.springframework.stereotype.Component;
 
@Component
public class UserProjectDTO {
	
	private Long userId;
	
	private String userFirstName;
 
	private String userLastName;
 
	private String userEmailId;
	
	private Long userMobileNumber;
	
	private long department;
	private String departmentName;
 
 
	private long region;
	private String regionName;  
	
	private String projects;
 
	public UserProjectDTO() {
		super();
	}
 
	public UserProjectDTO(Long userId, String userFirstName, String userLastName, String userEmailId,
			Long userMobileNumber, long department, String departmentName, long region, String regionName,
			String projects) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmailId = userEmailId;
		this.userMobileNumber = userMobileNumber;
		this.department = department;
		this.departmentName = departmentName;
		this.region = region;
		this.regionName = regionName;
		this.projects = projects;
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
 
	public String getProjects() {
		return projects;
	}
 
	public void setProjects(String projects) {
		this.projects = projects;
	}
	
	
	
 
	
 
 
	
 
 
}
 
