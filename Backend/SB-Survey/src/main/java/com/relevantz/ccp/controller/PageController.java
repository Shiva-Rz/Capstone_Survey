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

import com.relevantz.ccp.dto.PagesDTO;
import com.relevantz.ccp.model.Pages;
import com.relevantz.ccp.service.PagesService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class PageController {

	@Autowired
	PagesService pgService;

	@PostMapping("/page")
	public String performInsert(@RequestBody PagesDTO pages) {
		pgService.insert(pages);
		return "Record Inserted";

	}

	@PutMapping("/page")
	public String performUpdate(@RequestBody Pages pages) {
		pgService.update(pages);
		return "Record Updated";
	}

	@DeleteMapping("/page/{pageId}")
	public void performDelete(@PathVariable("pageId") long pageId) {
		pgService.delete(pageId);
	}

	@GetMapping("/getPage/{surveyId}")
	public List<Pages> getPagesDetails(@PathVariable("surveyId") long surveyId) {
		return pgService.getPages(surveyId);
	}

	@GetMapping("/page")
	public List<Pages> viewAllPagesDetails() {
		return pgService.getAllPagesDetails();
	}

	@GetMapping("/questionCount/{surveyId}")
	public long getQuestioncount(@PathVariable("surveyId") long surveyId) {
		return pgService.getQuestionCount(surveyId);
	}

	@GetMapping("/pageCount/{surveyId}")
	public long getPagecount(@PathVariable("surveyId") long surveyId) {
		return pgService.getPageCount(surveyId);
	}
	
	@GetMapping("/getPageDetail/{surveyId}")
	public List<Pages> getPagesBySurveyId(@PathVariable("surveyId") long surveyId) {
		return pgService.getPagesBySurveyId(surveyId);
	}

}
