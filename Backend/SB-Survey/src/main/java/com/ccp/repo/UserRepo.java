package com.ccp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccp.bean.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	@Query(value="select * FROM tbl_user where user_type='User'",nativeQuery = true)
	public List<User> getUserData();
}
