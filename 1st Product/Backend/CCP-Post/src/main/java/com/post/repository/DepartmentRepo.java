package com.post.repository;


 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.post.entity.Department;

 
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
	@Query(value="select * from tbl_department where region_id=?",nativeQuery=true)
	public List<Department> findByRegionId(long regionId);

}