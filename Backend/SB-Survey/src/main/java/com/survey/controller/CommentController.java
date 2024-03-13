package com.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.survey.bean.Comment;
import com.survey.service.CommentService;

public class CommentController {
	
	
	@Autowired
	 CommentService cmService;
	
	@PostMapping("/comment")
	public String performInsert(@RequestBody Comment comment) {
		cmService.insert(comment);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/comment")
	public String performUpdate(@RequestBody Comment comment) {
		cmService.update(comment);	
		return "Record Updated";
	}
	
	@DeleteMapping("/comment/{commentId}")
	public void performDelete(@PathVariable("commentId") long commentId) {
		cmService.delete(commentId);
	}
	
	@GetMapping("/comment")
	public List<Comment> viewAllCommentDetails(){
		return cmService.getAllCommentDetails();
	}

}
