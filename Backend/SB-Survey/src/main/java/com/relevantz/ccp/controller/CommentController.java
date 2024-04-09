package com.relevantz.ccp.controller;

//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.relevantz.ccp.dto.CommentDTO;
//import com.relevantz.ccp.model.Comment;
//import com.relevantz.ccp.service.CommentService;
//
//@RestController
//@CrossOrigin("http://localhost:4200/")
//public class CommentController {
//
//	@Autowired
//	CommentService cmService;
//
//	@PostMapping("/comment")
//	public String performInsert(@RequestBody CommentDTO comment) {
//		cmService.insert(comment);
//		return "Record Inserted";
//
//	}
//
//	@PutMapping("/comment")
//	public String performUpdate(@RequestBody Comment comment) {
//		cmService.update(comment);
//		return "Record Updated";
//	}
//
//	@DeleteMapping("/comment/{commentId}")
//	public void performDelete(@PathVariable("commentId") long commentId) {
//		cmService.delete(commentId);
//	}
//
//	@GetMapping("/comment")
//	public List<Comment> viewAllCommentDetails() {
//		return cmService.getAllCommentDetails();
//	}
//	
//	@GetMapping("/comment/{surveyId}") 
//	public List<CommentDTO> viewComment(@PathVariable("surveyId") long surveyId) { 
//    return cmService.getComment(surveyId); 
//
//	} 
//
//}
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PatchMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.relevantz.ccp.dto.CommentDTO;
import com.relevantz.ccp.model.Comment;
import com.relevantz.ccp.service.CommentService;

import jakarta.transaction.Transactional;

@RestController

@CrossOrigin(origins="http://localhost:4200/") 

public class CommentController {
 
	@Autowired

	CommentService commentService;

	@PostMapping("/comments")
	public void performCommentInsert(@RequestBody CommentDTO comment) {
		commentService.insertComment(comment);
	}
 
    @Transactional
	@PatchMapping("/comments/{id}")
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

}

