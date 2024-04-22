package com.relevantz.ccp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.relevantz.ccp.model.Invitation;


@Repository
public interface InvitationRepo extends JpaRepository<Invitation, Long> {
	
	@Query(value="select * from tbl_invitation where recipient_email=?",nativeQuery=true)
	Invitation findUserByEmail(String email);
}