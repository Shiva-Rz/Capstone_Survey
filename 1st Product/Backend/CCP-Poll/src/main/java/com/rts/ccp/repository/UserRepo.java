package com.rts.ccp.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rts.ccp.bean.User;
 
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	@Query(value="select * from tbl_user where user_type='employee'",nativeQuery=true)
	List<User> viewAllEmployees();
	
	User findByUserEmailId(String userEmailId);
	
	List<User> findByuserFirstNameContaining(String userFirstName);
}