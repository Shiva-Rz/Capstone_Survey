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

import com.survey.bean.Questions;
import com.survey.service.QuestionsService;

@RestController
public class QuestionController {

	
	@Autowired
	QuestionsService srService;
	
	@PostMapping("/question")
	public String performInsert(@RequestBody Questions question) {
		srService.insert(question);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/question")
	public String performUpdate(@RequestBody Questions question) {
		srService.update(question);	
		return "Record Updated";
	}
	
	@DeleteMapping("/question/{surveyId}")
	public void performDelete(@PathVariable("surveyId") long questionId) {
		srService.delete(questionId);
	}
	
	@GetMapping("/question")
	public List<Questions> viewAllQuestionsDetails(){
		return srService.getAllQuestionsDetails();
	}
	
}
