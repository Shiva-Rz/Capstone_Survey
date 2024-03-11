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

import com.survey.bean.Pages;
import com.survey.service.PagesService;

@RestController
public class PageController {
	
	@Autowired
	PagesService srService;
	
	@PostMapping("/page")
	public String performInsert(@RequestBody Pages pages) {
		srService.insert(pages);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/page")
	public String performUpdate(@RequestBody Pages pages) {
		srService.update(pages);	
		return "Record Updated";
	}
	
	@DeleteMapping("/page/{pageId}")
	public void performDelete(@PathVariable("pageId") long pageId) {
		srService.delete(pageId);
	}
	
	@GetMapping("/page")
	public List<Pages> viewAllPagesDetails(){
		return srService.getAllPagesDetails();
	}
	

}
