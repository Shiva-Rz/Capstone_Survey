package com.rts.ccp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rts.ccp.bean.Comment;
import com.rts.ccp.dto.CommentDTO;
import com.rts.ccp.service.CommentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
//	@PostMapping("/comments")
//	public void performCommentInsert(@RequestBody Comment comment) {
//		commentService.insertComment(comment);
//	}
	
	@PostMapping("/comments")
	public void performCommentInsert(@RequestBody CommentDTO comment) {
		commentService.insertComment(comment);
	}


	@PutMapping("/comments/{id}")
	public void performCommentUpdate(@PathVariable("id") long id) {
		commentService.updateComment(id);
	}

	@DeleteMapping("/comments/{id}")
	public void performCommentDelete(@PathVariable("id") long id) {
		commentService.deleteComment(id);
	}

	@GetMapping("/commentsFind")
	public List<Comment> viewAllCommentDetails() {
		return commentService.getAllCommentDetails();
	}
	
	@GetMapping("/commentsFind/{pollId}")
	public List<Comment> viewAllComment(@PathVariable("pollId") long pollId) {
		return commentService.getComment(pollId);
	}
}
