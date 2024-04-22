package com.relevantz.ccp.repository;
 
import java.util.List;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.relevantz.ccp.model.User;
 
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	@Query(value="select * from tbl_user where user_type='employee'",nativeQuery=true)
	List<User> viewAllEmployees();
	
	User findByUserEmailId(String userEmailId);


	@Query(value = "select * FROM tbl_user where user_type='User'", nativeQuery = true)
	public List<User> getUserData();
	
	@Query(value = "select * FROM tbl_user where user_id=?", nativeQuery = true)
	public User getByUserId(long userId);
	
	List<User> findByuserFirstNameContaining(String userFirstName);
}