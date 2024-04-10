package com.relevantz.ccp.dto;
 
import java.util.List;
 
import org.springframework.stereotype.Component;
 
@Component
public class RegionDTO {
    private Long regionId;
    private String regionName;
    private String regionLocation;
    private String regionTimezone;
    private List<Long> departments;
    
	public RegionDTO() {
		super();

	}
	
	public RegionDTO(Long regionId, String regionName, String regionLocation, String regionTimezone,
			List<Long> departments) {
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
	public List<Long> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Long> departments) {
		this.departments = departments;
	}

}