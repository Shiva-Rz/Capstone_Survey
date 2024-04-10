package com.relevantz.ccp.model;

public class UserProject {
	
	long user_user_id;
	long project_project_id;
	
	public UserProject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProject(long user_user_id, long project_project_id) {
		super();
		this.user_user_id = user_user_id;
		this.project_project_id = project_project_id;
	}
	public long getUser_user_id() {
		return user_user_id;
	}
	public void setUser_user_id(long user_user_id) {
		this.user_user_id = user_user_id;
	}
	public long getProject_project_id() {
		return project_project_id;
	}
	public void setProject_project_id(long project_project_id) {
		this.project_project_id = project_project_id;
	}
	
	

}
