package com.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.post.entity.Reactions;

@Repository
public interface ReactionsRepo extends JpaRepository<Reactions, Long> {
	
	@Modifying
	@Query(value="delete from tbl_post_reaction order by reaction_id desc limit 1",nativeQuery=true)
	public int deleteBylastId();
}
