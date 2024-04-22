package com.post.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.Comment;
import com.post.entity.CommentDTO;
import com.post.entity.Post;
import com.post.entity.User;
import com.post.repository.CommentRepo;
import com.post.repository.PostRepo;
import com.post.repository.UserRepo;


@Service
public class CommentService {
	
	@Autowired
	CommentRepo commentRepo;
	
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
	
	
//	@Autowired
//	CommentRepoJpa commentRepoJpa;
//	
//	public boolean insertComment(Comment comment) {
//		commentRepo.save(comment);
//		return true;
//	}
	
	public boolean insertComment(CommentDTO cmt) {
		
		Post post = postRepo.findById(cmt.getPostId()).get();
		User user = userRepo.findById(cmt.getUserId()).get();
		
		Comment comment = new Comment();
		comment.setBody(cmt.getBody());
		comment.setCreatedAt(cmt.getCreatedAt());
		comment.setParentId(cmt.getParentId());
		comment.setPost(post);
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

}
