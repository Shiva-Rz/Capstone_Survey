package com.ccp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccp.bean.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

	@Query(value="select * FROM tbl_project where department_id=?",nativeQuery = true) 
	public List<Project> findProjectByDepartment(long departmentId);
}
