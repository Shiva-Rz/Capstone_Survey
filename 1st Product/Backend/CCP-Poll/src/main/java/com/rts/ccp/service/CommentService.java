package com.rts.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Comment;
import com.rts.ccp.dto.CommentDTO;
import com.rts.ccp.bean.Option;
import com.rts.ccp.bean.OptionResponse;
import com.rts.ccp.dto.OptionResponseDTO;
import com.rts.ccp.bean.Poll;
import com.rts.ccp.bean.User;
import com.rts.ccp.repository.CommentRepo;
import com.rts.ccp.repository.PollRepo;
import com.rts.ccp.repository.UserRepo;

@Service
public class CommentService {
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	PollRepo pollRepo;
	
	@Autowired
	UserRepo userRepo;
	
//	public boolean insertComment(Comment comment) {
//		commentRepo.save(comment);
//		return true;
//	}
	
	public boolean insertComment(CommentDTO cmt) {
		
		Poll poll = pollRepo.findById(cmt.getPollId()).get();
		User user = userRepo.findById(cmt.getUserId()).get(); 
		
		Comment comment = new Comment();
		comment.setBody(cmt.getBody());
		comment.setCreatedAt(cmt.getCreatedAt());
		comment.setParentId(cmt.getParentId());
		comment.setPoll(poll);
		comment.setUser(user);
		
		commentRepo.save(comment);
		return true;
	}


//	public boolean insertComment(CommentDTO cmt) {
//		Poll poll = pollRepo.findById(cmt.getPollId()).get();
//		User user = userRepo.findById(cmt.getUserid()).get();
//		
//		Comment comment = new Comment();
//		comment.setPollId(poll);
//		comment.setUser(user);
//		
//		commentRepo.save(comment);
//		return true;
//	}

	public boolean updateComment(long id) {
		commentRepo.updateById(id);
		return true;
	}

	public boolean deleteComment(Long id) {
		commentRepo.deleteById(id);
		return true;
	}

	public List<Comment> getAllCommentDetails() {
		Iterator<Comment> it = commentRepo.findAll().iterator();
		ArrayList<Comment> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public List<Comment> getComment(long pollId) {
		Iterator<Comment> it = commentRepo.findByPollId(pollId).iterator();
		ArrayList<Comment> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	}


