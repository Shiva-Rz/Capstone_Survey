package com.survey.repo;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Department;

public interface DepartmentRepo extends CrudRepository<Department, Long>{
	
	
//	@Query(value="select * FROM tbl_department where project_id=1",nativeQuery = true)
//	public List<Department> getDepartment();

}
