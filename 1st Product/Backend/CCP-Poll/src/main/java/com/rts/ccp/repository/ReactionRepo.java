package com.rts.ccp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rts.ccp.bean.Reaction;

public interface ReactionRepo extends CrudRepository<Reaction, Long>{

   @Query(value = "select COUNT(*)  FROM tbl_poll_reaction WHERE poll_id=?", nativeQuery = true)
   public long getReactionCount(long pollId);
   
   @Modifying
   @Query(value= "delete from tbl_poll_reaction order by reaction_id desc limit 1;", nativeQuery = true)
   public int deletebylastId();
}
