package com.rts.ccp.controller;

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

import com.rts.ccp.bean.Option;
import com.rts.ccp.dto.OptionDTO;
import com.rts.ccp.service.OptionService;
import com.rts.ccp.service.PollService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OptionController {

	@Autowired
	OptionService optionService;

	@Autowired
	PollService pollService;

	@PostMapping("/option")
	public String performOptionInsert(@RequestBody Option option) {
		optionService.insertOption(option);
		return "Option Inserted!";
	}

	@PutMapping("/option")
	public String performOptionUpdate(@RequestBody Option option) {
		optionService.updateOption(option);
		return "Option Updated!";
	}

	@DeleteMapping("/option/{optionId}")
	public String performOptionDelete(@PathVariable("optionId") long optionId) {
		optionService.deleteOption(optionId);
		return "Option Deleted!";
	}

	@GetMapping("/option")
	public List<Option> viewAllOptionDetails() {
		return optionService.getAllOptionDetails();
	}

	@GetMapping("/options")
	public List<OptionDTO> OptionDetails() {
		return optionService.optionsDetails();
	}

}
