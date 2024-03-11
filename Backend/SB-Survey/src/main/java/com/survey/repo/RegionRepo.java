package com.survey.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Region;

public interface RegionRepo extends CrudRepository<Region, Long>{
	
	@Query(value="select region_name from tbl_region group by region_name",nativeQuery = true)
	public List<Region> groupByRegionName();
	

}
