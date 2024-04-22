package com.post.entity;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_region")

@Component
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "region_name",unique = true)
    private String regionName;

    @Column(name = "region_location")
    private String regionLocation;

    @Column(name = "region_timezone")
    private String regionTimezone;

    @JsonIgnoreProperties("region")
    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Department> departments;

	public Region() {
		super();
	}

	public Region(Long regionId, String regionName, String regionLocation, String regionTimezone,
			List<Department> departments) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
		this.regionLocation = regionLocation;
		this.regionTimezone = regionTimezone;
		this.departments = departments;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
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

    
}