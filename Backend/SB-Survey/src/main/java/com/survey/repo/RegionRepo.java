package com.survey.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Region;

public interface RegionRepo extends CrudRepository<Region, Long>{
	
	
}
