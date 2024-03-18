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

import com.relevantz.ccp.model.Questions;
import com.relevantz.ccp.model.Responses;
import com.relevantz.ccp.model.ResponsesDTO;
import com.relevantz.ccp.service.ResponseService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ReponsesController {

	@Autowired
	ResponseService rsService;

	@PostMapping("/response")
	public void performInsert(@RequestBody ResponsesDTO reponsesDto) {
		rsService.insert(reponsesDto);

	}

	@PutMapping("/response")
	public String performUpdate(@RequestBody Responses reponses) {
		rsService.update(reponses);
		return "Record Updated";
	}

	@DeleteMapping("/response/{responseId}")
	public void performDelete(@PathVariable("responseId") long responseId) {
		rsService.delete(responseId);
	}

	@GetMapping("/response")
	public List<Responses> viewAllResponses() {
		return rsService.getAllReponsesDetails();
	}
	
	@GetMapping("/getresponses/{surveyId}")
	public List<Responses> viewResponses(@PathVariable("surveyId") long surveyId) {
		return rsService.getAllReponses(surveyId);
	}

}
