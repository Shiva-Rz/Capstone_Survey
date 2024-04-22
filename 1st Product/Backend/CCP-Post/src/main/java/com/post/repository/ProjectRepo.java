package com.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.post.entity.Project;


 
@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
	@Query(value="select * from tbl_project where department_id=?",nativeQuery=true)
	public List<Project> findByProjectId(long departmentId);
	
//	@Query(value="select * from tbl_user_project where user_user_id=?",nativeQuery=true)
//	public List<List<Long>> findUserProjectId(long userId);
	
	@Query(value="select project_project_id from tbl_user_project where user_user_id=?",nativeQuery=true)
	public List<Long> findUserProjectId(long userId);

}