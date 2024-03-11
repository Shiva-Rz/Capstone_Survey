package com.survey.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Reaction;

public interface ReactionRepo extends CrudRepository<Reaction, Long> {
	
	@Query(value="select * FROM tbl_reaction where survey_id=1",nativeQuery = true)
	public List<Reaction> getReaction();

}
