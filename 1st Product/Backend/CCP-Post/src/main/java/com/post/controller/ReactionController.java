package com.post.controller;

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

import com.post.entity.ReactionDTO;
import com.post.entity.Reactions;
import com.post.service.ReactionService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin("http://localhost:4200/") 
public class ReactionController {
	
	@Autowired
	ReactionService reactionService;

	@PostMapping("/reactionInsert")
	public boolean performInsert(@RequestBody ReactionDTO reaction) {
		reactionService.addPost(reaction);
		return true;
	}

	@PutMapping("/reactionUpdate")
	public boolean performUpdate(@RequestBody Reactions reaction) {
		reactionService.updatePost(reaction);
		return true;
	}
	
	@Transactional
	@DeleteMapping("/reactionDelete")
	public String performDelete() {
		reactionService.deleteReactionById();
		return "Reaction Deleted";

	}

	@GetMapping("/viewAllReaction")
	public List<Reactions> viewAllReactionsDetails() {
		return reactionService.getAllReactionDetails();

	}

}
