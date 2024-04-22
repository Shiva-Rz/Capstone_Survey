package com.rts.ccp.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rts.ccp.bean.Department;
import com.rts.ccp.bean.Project;
import com.rts.ccp.bean.UserProject;
 
@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
	@Query(value="select * from tbl_project where department_id=?",nativeQuery=true)
	public List<Project> findByProjectId(long departmentId);
	
	@Query(value="select * from tbl_user_project where user_user_id=?",nativeQuery=true)
	public List<List<Long>> findUserProjectName(long userId);
	
	@Query(value="select project_project_id from tbl_user_project where user_user_id=?",nativeQuery=true)
	public List<Long> findUserProjectId(long userId);
}
	


