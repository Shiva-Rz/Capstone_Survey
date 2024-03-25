package com.relevantz.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.CommentDTO;
import com.relevantz.ccp.model.Comment;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.CommentRepo;

@Service
public class CommentService {

	@Autowired
	CommentRepo crRepo;

	public boolean insert(Comment comment) {
		crRepo.save(comment);
		return true;
	}

	public boolean update(Comment comment) {
		crRepo.save(comment);
		return true;
	}

	public boolean delete(long commentId) {
		crRepo.deleteById(commentId);
		return true;
	}

	public List<Comment> getAllCommentDetails() {
		Iterator<Comment> it = crRepo.findAll().iterator();
		ArrayList<Comment> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	    public List<CommentDTO> getComment(long surveyId) { 
        Iterator<Comment> it = crRepo.getCommentBySurveyId(surveyId).iterator(); 
        ArrayList<CommentDTO> list = new ArrayList<>(); 
        while (it.hasNext()) { 
            //list.add(it.next()); 
            Comment comment=it.next(); 
            CommentDTO commentDto=new CommentDTO(); 
            commentDto.setCommentId(comment.getCommentId()); 
            commentDto.setComments(comment.getComments()); 
            User user=comment.getUser(); 
            commentDto.setUser(user.getUserId()); 
            list.add(commentDto); 
        } 
        return list; 

	} 

}
