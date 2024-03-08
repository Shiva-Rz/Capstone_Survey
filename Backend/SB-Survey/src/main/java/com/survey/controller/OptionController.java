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

import com.survey.bean.Options;
import com.survey.service.OptionService;

@RestController
public class OptionController {
	
	
	@Autowired
	 OptionService srService;
	
	@PostMapping("/option")
	public String performInsert(@RequestBody Options options) {
		srService.insert(options);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/option")
	public String performUpdate(@RequestBody Options options) {
		srService.update(options);	
		return "Record Updated";
	}
	
	@DeleteMapping("/option/{optionId}")
	public void performDelete(@PathVariable("optionId") long optionId) {
		srService.delete(optionId);
	}
	
	@GetMapping("/option")
	public List<Options> viewAllOptionsDetails(){
		return srService.getAllOptionsDetails();
	}
	

}
