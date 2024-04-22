package com.rts.ccp.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rts.ccp.bean.Poll;
import com.rts.ccp.dto.OptionDTO;
import com.rts.ccp.dto.PollDTO;
import com.rts.ccp.service.PollService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class PollController {

	@Autowired
	PollService pollService;

//	@PostMapping("/poll")
//	public void performPollInsert(@RequestBody Poll poll) {
//		pollService.insertPoll(poll);
//
//	}
	
	@PostMapping("/poll")
	public void performPollInsert(@RequestBody PollDTO poll) throws Exception {
		pollService.insertPoll(poll);
 
	}

	@PutMapping("/updateDraft")
	public void performPollUpdate(@RequestBody PollDTO poll) {
		System.out.println(poll.getPollId()+" "+poll.isStatus());
		
	  pollService.updatePoll(poll);
 
		
	}

	@DeleteMapping("/poll/{pollId}")
	public String performPollDelete(@PathVariable("pollId") long pollId) {
		pollService.deletePoll(pollId);
		return "Poll Deleted!";
	}

	@GetMapping("/poll")
	public List<Poll> viewAllPollDetails() {
		return pollService.getAllPollDetails();
	}


	@GetMapping("/poll/{pollId}")
	public List<Poll> getPollById(@PathVariable("pollId") long pollId) {
		return pollService.pollDetails(pollId);
	}
	
	@GetMapping("/published")
	  public ResponseEntity<List<Poll>> getPublishedPoll() {
	    List<Poll> publishedPoll = pollService.getPublishedPoll();
	    return ResponseEntity.ok(publishedPoll);
	  }

	  @GetMapping("/drafts")
	  public ResponseEntity<List<Poll>> getDraftPoll() {
	    List<Poll> draftPoll = pollService.getDraftPoll();
	    return ResponseEntity.ok(draftPoll);
	  }
	  
	  @GetMapping("/changeStatus")
		public boolean chageStatus() throws ParseException {
			return pollService.compareDate();
		}

	  @GetMapping("/draft/{pollId}")
		public PollDTO getPollDetailsById(@PathVariable("pollId") long pollId) {
			return pollService.getPollDetails(pollId);
		}
	  
	  @GetMapping("/draftOption/{pollId}")
		public List<OptionDTO> getPollOptionsById(@PathVariable("pollId") long pollId) {
			return pollService.getPollOptions(pollId);
	  }
	  
}