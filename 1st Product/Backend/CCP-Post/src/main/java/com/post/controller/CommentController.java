package com.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.post.entity.Comment;
import com.post.entity.CommentDTO;
import com.post.service.CommentService;

import jakarta.transaction.Transactional;
@RestController
@CrossOrigin("http://localhost:4200/") 
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
