package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.relevantz.ccp.model.Region;


@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {

    @Query(value = "select region_name from tbl_region group by region_name", nativeQuery = true)
	public List<Region> groupByRegionName();
}