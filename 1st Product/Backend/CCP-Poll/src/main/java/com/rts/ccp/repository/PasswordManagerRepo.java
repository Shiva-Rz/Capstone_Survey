package com.rts.ccp.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rts.ccp.bean.PasswordManager;
 
@Repository
public interface PasswordManagerRepo extends JpaRepository<PasswordManager, Long> {
	
	
	@Query(value="select * from tbl_password_manager where login_id=?",nativeQuery=true)
	PasswordManager findUser(Long loginId);
}