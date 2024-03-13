package com.ccp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccp.bean.Region;

@Repository
public interface RegionRepo extends CrudRepository<Region, Long> {

//	@Query(value = "select region_name from tbl_region group by region_name", nativeQuery = true)
//	public List<String> groupByRegionName();
}
