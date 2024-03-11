package com.survey.bean;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "tbl_department")
public class Department {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "department_id")
	private Long departmentId;

	@Column(name = "department_name")
	private String departmentName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="department_id")
	private List<Project> projects;

	public Department() {
		super();

	}

	
	public Department(Long departmentId, String departmentName, List<Project> projects) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
