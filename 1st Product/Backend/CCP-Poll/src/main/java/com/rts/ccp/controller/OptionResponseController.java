package com.rts.ccp.controller;
 
import java.util.HashMap;

import java.util.List;

import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
 
import com.rts.ccp.bean.Option;

import com.rts.ccp.bean.OptionResponse;

import com.rts.ccp.repository.OptionResponseRepo;

import com.rts.ccp.service.OptionResponseService;
 
import jakarta.transaction.Transactional;
 
@RestController

@CrossOrigin("http://localhost:4200/")

public class OptionResponseController {
 
   

    @Autowired

    private OptionResponseService optionResponseService;

    @Autowired

    OptionResponseRepo optionResponseRepo;

    @PostMapping("/{pollId}/{optionId}/{userId}")

    public ResponseEntity<OptionResponse> createVote(@PathVariable int pollId, @PathVariable int optionId, @PathVariable int userId) {

        // Ignore requests for favicon.ico

        if ("favicon.ico".equals(String.valueOf(pollId)) || "favicon.ico".equals(String.valueOf(optionId)) || "favicon.ico".equals(String.valueOf(userId))) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }

        OptionResponse createdVote = optionResponseService.createVote(pollId, optionId, userId);

        if (createdVote != null) {

            return new ResponseEntity<>(createdVote, HttpStatus.CREATED);

        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

	@PutMapping("/{optionId}/{userId}")

	public void performResponseById(@PathVariable long optionId, @PathVariable long userId) {

		optionResponseService.updateReponseById(optionId,userId);

	}

//    @GetMapping("/{voteId}")

//    public ResponseEntity<Vote> getVoteById(@PathVariable  Long voteId) {

//        Vote vote = voteService.getVoteById(voteId);

//        if (vote != null) {

//            return new ResponseEntity<>(vote, HttpStatus.OK);

//        } else {

//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

//        }

//    }

//    

    @GetMapping("counts/{pollId}")

    public  Map<Integer, Integer> getVoteCounts(@PathVariable int pollId) {

      List<OptionResponse> votes = optionResponseRepo.getPollResponse(pollId);

      Map<Integer, Integer> voteCounts = new HashMap<>();

      for (OptionResponse vote : votes) {

          Integer optionId = vote.getOptionId();

          voteCounts.put(optionId, voteCounts.getOrDefault(optionId, 0) + 1);

      }

      return voteCounts;

  }

}
