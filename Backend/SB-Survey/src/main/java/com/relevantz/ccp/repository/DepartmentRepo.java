package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Department;

public interface DepartmentRepo extends CrudRepository<Department, Long> {

//	@Query(value="select * FROM tbl_department where project_id=1",nativeQuery = true)
//	public List<Department> getDepartment();

//	@Query(value="select * FROM tbl_department where survey_id=1",nativeQuery = true)
//	public List<Reaction> getReaction();
//	
//	public List<Department> find(String userName);

//	public List<Department> findByRegionId(long regionId);

	@Query(value = "select * FROM tbl_department where region_id=?", nativeQuery = true)
	public List<Department> findByRegionId(long regionId);

}
