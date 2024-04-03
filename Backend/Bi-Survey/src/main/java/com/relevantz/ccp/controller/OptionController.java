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

import com.relevantz.ccp.dto.OptionsDTO;
import com.relevantz.ccp.model.Options;
import com.relevantz.ccp.service.OptionService;

@RestController
@CrossOrigin("http://localhost:4200/")
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

	@GetMapping("/getOption/{surveyId}")

	public List<OptionsDTO> viewAllOptions(@PathVariable("surveyId") long surveyId) {

		return srService.getAllOptions(surveyId);
	}

	@GetMapping("/option")
	public List<Options> viewAllOptionsDetails() {
		return srService.getAllOptionsDetails();
	}

}
