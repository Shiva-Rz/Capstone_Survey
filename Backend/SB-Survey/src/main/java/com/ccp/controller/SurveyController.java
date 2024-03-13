package com.ccp.controller;

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

import com.ccp.bean.Survey;
import com.ccp.bean.SurveyDTO;
import com.ccp.service.SurveyService;

@RestController
@CrossOrigin("http://localhost:4200")
public class SurveyController {

	@Autowired
	SurveyService srService;
	
	@PostMapping("/surveycreation")
	public void performInsert(@RequestBody SurveyDTO surveydto) {
		srService.insert(surveydto);
	    
	}
	
//	@PutMapping("/survey")
//	public String performUpdate(@RequestBody Survey survey) {
//		srService.update(survey);	
//		return "Record Updated";
//	}
	
	@DeleteMapping("/survey/{surveyId}")
	public void performDelete(@PathVariable("surveyId") long surveyId) {
		srService.delete(surveyId);
	}
	
	@GetMapping("/survey/{surveyName}")
	public List<Survey> viewSurveyDetails(@PathVariable("surveyName") String surveyName){
	    return srService.getSurveyDetails(surveyName);
		
	}
	
	@GetMapping("/survey")
	public List<Survey> viewAllSurveyDetails(){
		return srService.getAllSurveyDetails();
	}
	
}
