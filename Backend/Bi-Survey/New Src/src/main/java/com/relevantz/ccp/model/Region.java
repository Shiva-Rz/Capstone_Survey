package com.relevantz.ccp.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "tbl_region")
@Component
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	private long regionId;

	@Column(name = "region_name")
	private String regionName;

	@Column(name = "region_location")
	private String regionLocation;

	@Column(name = "region_timezone")
	private String regionTimezone;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "region_id")
	private List<Department> departments;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "region_id")
	private List<Survey> survey;

	public Region() {
		super();

	}

	public Region(long regionId, String regionName, String regionLocation, String regionTimezone,
			List<Department> departments, List<Survey> survey) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
		this.regionLocation = regionLocation;
		this.regionTimezone = regionTimezone;
		this.departments = departments;
		this.survey = survey;
	}

	public long getRegionId() {
		return regionId;

	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;

	}

	public String getRegionName() {
		return regionName;

	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;

	}

	public String getRegionLocation() {
		return regionLocation;

	}

	public void setRegionLocation(String regionLocation) {
		this.regionLocation = regionLocation;

	}

	public String getRegionTimezone() {
		return regionTimezone;

	}

	public void setRegionTimezone(String regionTimezone) {
		this.regionTimezone = regionTimezone;

	}

	public List<Department> getDepartments() {
		return departments;

	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;

	}

	public List<Survey> getSurvey() {
		return survey;
	}

	public void setSurvey(List<Survey> survey) {
		this.survey = survey;
	}

}
