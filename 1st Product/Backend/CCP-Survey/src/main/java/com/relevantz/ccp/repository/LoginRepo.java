package com.relevantz.ccp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.relevantz.ccp.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, String> {
	Login findByUserEmailIdAndPassword(String userEmailId, String password);
    Login findByUserEmailId(String userEmailId);
    
    @Query(value="select * from tbl_login where user_id=?",nativeQuery=true) 

    Login findByUserId(Long userId);
}