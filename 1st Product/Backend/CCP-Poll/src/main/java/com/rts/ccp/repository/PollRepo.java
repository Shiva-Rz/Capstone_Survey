package com.rts.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rts.ccp.bean.Poll;

public interface PollRepo extends JpaRepository<Poll, Long> {

	@Query(value = "select * from tbl_poll where poll_id=?", nativeQuery = true)
	public List<Poll> findByPollId(long pollId);

}
