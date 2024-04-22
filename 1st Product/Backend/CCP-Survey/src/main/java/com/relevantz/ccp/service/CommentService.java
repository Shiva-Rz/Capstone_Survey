package com.relevantz.ccp.service;

//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.relevantz.ccp.dto.CommentDTO;
//import com.relevantz.ccp.model.Comment;
//import com.relevantz.ccp.model.Survey;
//import com.relevantz.ccp.model.User;
//import com.relevantz.ccp.repository.CommentRepo;
//import com.relevantz.ccp.repository.SurveyRepo;
//import com.relevantz.ccp.repository.UserRepo;
//
//@Service
//public class CommentService {
//
//	@Autowired
//	CommentRepo crRepo;
//	
//	@Autowired
//	Comment comment;
//	
//	@Autowired
//	SurveyRepo srRepo;
//	
//	@Autowired
//    UserRepo urRepo;
//
//	public boolean insert(CommentDTO commentdto) {
//		Survey survey=srRepo.findById(commentdto.getSurveyId()).get();
//		User user=urRepo.findById(commentdto.getUserId()).get();
//		comment.setCommentId(crRepo.count()+1);
//		comment.setComments(commentdto.getComments());
//		comment.setSurvey(survey);
//		comment.setUser(user);
//		crRepo.save(comment);
//		return true;
//	}
//
//	public boolean update(Comment comment) {
//		crRepo.save(comment);
//		return true;
//	}
//
//	public boolean delete(long commentId) {
//		crRepo.deleteById(commentId);
//		return true;
//	}
//
//	public List<Comment> getAllCommentDetails() {
//		Iterator<Comment> it = crRepo.findAll().iterator();
//		ArrayList<Comment> list = new ArrayList<>();
//		while (it.hasNext()) {
//			list.add(it.next());
//		}
//		return list;
//	}
//	
//	    public List<CommentDTO> getComment(long surveyId) { 
//        Iterator<Comment> it = crRepo.getCommentBySurveyId(surveyId).iterator(); 
//        ArrayList<CommentDTO> list = new ArrayList<>(); 
//        while (it.hasNext()) { 
//            //list.add(it.next()); 
//            Comment comment=it.next(); 
//            CommentDTO commentDto=new CommentDTO(); 
//            commentDto.setCommentId(comment.getCommentId()); 
//            commentDto.setComments(comment.getComments()); 
//            User user=comment.getUser(); 
//            commentDto.setUser(user.getUserFirstName()); 
//            list.add(commentDto); 
//        } 
//        return list; 
//
//	} 
//
//}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.CommentDTO;
import com.relevantz.ccp.model.Comment;
import com.relevantz.ccp.model.Survey;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.CommentRepo;
import com.relevantz.ccp.repository.SurveyRepo;
import com.relevantz.ccp.repository.UserRepo;
 
 
@Service
public class CommentService {
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	SurveyRepo surveyRepo;

	public boolean insertComment(CommentDTO cmt) {
		
		Survey survey = surveyRepo.findById(cmt.getSurveyId()).get();
		User user = userRepo.findById(cmt.getUserId()).get();
		
		Comment comment = new Comment();
		comment.setBody(cmt.getBody());
		comment.setCreatedAt(cmt.getCreatedAt());
		comment.setParentId(cmt.getParentId());
		comment.setSurvey(survey);
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

