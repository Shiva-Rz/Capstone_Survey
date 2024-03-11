package com.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.survey.bean.Responses;
import com.survey.service.ResponseService;

@RestController
public class ReponsesController {
	
	@Autowired
	ResponseService rsService;
	
	@PostMapping("/response")
	public String performInsert(@RequestBody Responses reponses) {
		rsService.insert(reponses);
	    return "Record Inserted";
	    
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
	public List<Responses> viewAllResponsesDetails(){
		return rsService.getAllReponsesDetails();
	}
	

}
