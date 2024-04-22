package com.rts.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rts.ccp.bean.Option;

public interface OptionRepo extends CrudRepository<Option, Long> {

	@Query(value = "select * from Option where OptionId=?", nativeQuery = true)
	public List<Option> findByOptionId(long pollId);
	
	
//	@Query(value = "from Option o  inner join o.pollId p on o.pollId = p.pollId")
//	public List<Option> findOption();

	@Query(value = "select * from tbl_poll_option where poll_id=?", nativeQuery = true)
	public List<Option> findByPollId(long pollId);
}