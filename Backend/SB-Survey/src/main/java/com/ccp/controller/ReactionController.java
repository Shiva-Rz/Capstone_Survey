package com.ccp.controller;

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

import com.ccp.bean.Comment;
import com.ccp.bean.Reaction;
import com.ccp.service.CommentService;
import com.ccp.service.ReactionService;

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
	public List<Reaction> viewAllReactionDetails(){
		return rnService.getAllReactionDetails();
	}

	@GetMapping("/reactiondetail")
	public List<Reaction> viewDetails(){
		return rnService.DepartmentDetails();
	}

}
