package com.ccp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ccp.bean.Reaction;

public interface ReactionRepo extends CrudRepository<Reaction, Long> {
	
	@Query(value="select * FROM tbl_reaction where survey_id=1",nativeQuery = true)
	public List<Reaction> getReaction();

}
