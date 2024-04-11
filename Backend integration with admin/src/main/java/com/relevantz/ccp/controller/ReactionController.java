package com.relevantz.ccp.controller;

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

import com.relevantz.ccp.dto.ReactionDTO;
import com.relevantz.ccp.model.Reaction;
import com.relevantz.ccp.service.ReactionService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ReactionController {

	@Autowired
	ReactionService rnService;

	@PostMapping("/reaction")
	public String performInsert(@RequestBody Reaction reaction) {
		rnService.insert(reaction);
		return "Record Inserted";

	}
	
	@PostMapping("/reactionInsert")
	public void performReactionInsert(@RequestBody ReactionDTO reaction) {
		rnService.insertReaction(reaction);
	}

	@PutMapping("/reaction")
	public String performUpdate(@RequestBody Reaction reaction) {
		rnService.update(reaction);
		return "Record Updated";
	}

	@DeleteMapping("/reaction/{reactionId}")
	public void performDelete(@PathVariable("reactionId") long reactionId) {
		rnService.delete(reactionId);
	}

	@GetMapping("/reaction")
	public List<Reaction> viewAllReactionDetails() {
		return rnService.getAllReactionDetails();
	}
	
	@GetMapping("/getReactionCount/{surveyId}")
	public long performReactionCount (@PathVariable("surveyId") long surveyId) {
		return rnService.getReactionCount(surveyId);
		//return reactionService.getAllReactionDetails();
	}
	
	@GetMapping("/getReactionCountByRegion/{userId}")
	public List<ReactionDTO> performReactionCountByRegion (@PathVariable("userId") long userId) {
		return rnService.getReactionCountByRegion(userId);
		//return reactionService.getAllReactionDetails();
	}
	
	@Transactional
	@DeleteMapping("/reactionDelete")
	public String performReactionDeleteById() {
		rnService.deleteReactionById();
		return "Reaction Deleted!";
	}

	@GetMapping("/reactiondetail")
	public List<Reaction> viewDetails() {
		return rnService.DepartmentDetails();
	}

}
