package com.post.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.Post;
import com.post.entity.ReactionDTO;
import com.post.entity.Reactions;
import com.post.entity.User;
import com.post.repository.PostRepo;
import com.post.repository.ReactionsRepo;
import com.post.repository.UserRepo;

@Service
public class ReactionService {
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ReactionsRepo reactionrepo;

	public boolean addPost(ReactionDTO reaction) {
		Post postId = postRepo.findById(reaction.getPostId()).get();
		User userId = userRepo.findById(reaction.getUserId()).get();
		
		Reactions reactions = new Reactions();
		reactions.setPostId(postId);
		reactions.setUser(userId);
		
		reactionrepo.save(reactions);
		
		
		return true;
	}
	
//	public boolean addReaction(ReactionDTO reactdto) {
//		Reactions react = new Reactions();
//		react.setPostId();
//     	return false;
//		
//	}
//	
	
	public boolean updatePost(Reactions reaction) {
		reactionrepo.save(reaction);
		return true;
	}
	
	public boolean deleteReactionById() {
		reactionrepo.deleteBylastId();
		return true;
	}
	
	public List<Reactions> getAllReactionDetails() {
		Iterator<Reactions> it=reactionrepo.findAll().iterator();
		ArrayList<Reactions> list = new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
