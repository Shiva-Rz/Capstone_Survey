package com.rts.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Option;
import com.rts.ccp.bean.OptionResponse;
import com.rts.ccp.dto.OptionResponseDTO;
import com.rts.ccp.bean.Poll;
import com.rts.ccp.bean.Reaction;
import com.rts.ccp.dto.ReactionDTO;
import com.rts.ccp.bean.User;
import com.rts.ccp.repository.PollRepo;
import com.rts.ccp.repository.ReactionRepo;
import com.rts.ccp.repository.UserRepo;

@Service
public class ReactionService {

	@Autowired
	ReactionRepo reactionRepo;
	
    @Autowired
    PollRepo pollRepo;
    
    @Autowired
    UserRepo userRepo;
    
	public boolean insertReaction(ReactionDTO reaction) {
		Poll poll = pollRepo.findById(reaction.getPollId()).get();
		User user = userRepo.findById(reaction.getUserid()).get();
		
		Reaction reactions= new Reaction();
		reactions.setPollId(poll);
		reactions.setUserId(user);
		
		reactionRepo.save(reactions);
		return true;
	}
	
//
//	public boolean insertReaction(Reaction reaction) {
//		reactionRepo.save(reaction);
//		return true;
//	}

	public boolean updateReaction(Reaction reaction) {
		reactionRepo.save(reaction);
		return true;
	}

//	public boolean deleteReaction(Long reactionId) {
//		reactionRepo.deleteById(reactionId);
//		return true;
//	}
	
	public boolean deleteReactionById() {
		reactionRepo.deletebylastId();
		return true;
	}

	public List<Reaction> getAllReactionDetails() {
		Iterator<Reaction> it = reactionRepo.findAll().iterator();
		ArrayList<Reaction> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	 
    public long getReactionCount(long pollId){
        return reactionRepo.getReactionCount(pollId);
    }
    
}