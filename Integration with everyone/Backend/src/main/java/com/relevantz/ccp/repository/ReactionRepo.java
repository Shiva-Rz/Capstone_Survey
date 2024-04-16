package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Reaction;

public interface ReactionRepo extends CrudRepository<Reaction, Long> {

	@Query(value = "select * FROM tbl_survey_reaction where survey_id=1", nativeQuery = true)
	public List<Reaction> getReaction();
	
	@Query(value = "select COUNT(*)  FROM tbl_survey_reaction WHERE survey_id=?", nativeQuery = true)
	   public long getReactionCount(long surveyId);
	
	@Modifying
	@Query(value= "delete from tbl_survey_reaction order by reaction_id desc limit 1;", nativeQuery = true)
	public int deletebylastId();
	
	

}
