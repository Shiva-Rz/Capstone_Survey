package com.rts.ccp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rts.ccp.bean.Reaction;
import com.rts.ccp.dto.ReactionDTO;
import com.rts.ccp.service.ReactionService;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReactionController {
	
	@Autowired
	ReactionService reactionService;
	
	@PostMapping("/reactionInsert")
	public void performReactionInsert(@RequestBody ReactionDTO reaction) {
		reactionService.insertReaction(reaction);
	}
	
//	@PostMapping("/reactionInsert")
//	public String performReactionInsert(@RequestBody Reaction reaction) {
//		reactionService.insertReaction(reaction);
//		return "Reaction Inserted!";
//	}

	@PutMapping("/reactionUpdate")
	public String performReactionUpdate(@RequestBody Reaction reaction) {
		reactionService.updateReaction(reaction);
		return "Reaction Updated!";
	}

//	@DeleteMapping("/reactionDelete/{reactionId}")
//	public String performReactionDelete(@PathVariable("reactionId") long reactionId) {
//		reactionService.deleteReaction(reactionId);
//		return "Reaction Deleted!";
//	}
	
	@Transactional
	@DeleteMapping("/reactionDelete")
	public String performReactionDeleteById() {
		reactionService.deleteReactionById();
		return "Reaction Deleted!";
	}

	@GetMapping("/viewAllReaction")
	public List<Reaction> viewAllReactionDetails() {
		return reactionService.getAllReactionDetails();
	}
	
	@GetMapping("/getReactionCount/{pollId}")
	public long performReactionCount (@PathVariable("pollId") long pollId) {
		return reactionService.getReactionCount(pollId);
		//return reactionService.getAllReactionDetails();
	}
	
}
