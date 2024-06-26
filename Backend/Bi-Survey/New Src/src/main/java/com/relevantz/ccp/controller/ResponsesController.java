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

import com.relevantz.ccp.dto.ResponsesDTO;
import com.relevantz.ccp.model.Questions;
import com.relevantz.ccp.model.Responses;
import com.relevantz.ccp.service.ResponseService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ResponsesController {

	@Autowired
	ResponseService rsService;

	@PostMapping("/response")
	public String performInsert(@RequestBody ResponsesDTO responsesDto) {
		rsService.insert(responsesDto);
		return "Record Inserted";

	}
	
//	@PostMapping("/responselist")
//	public String performInsertList(@RequestBody ResponsesDTO reponsesDto) {
//		rsService.insertList(reponsesDto);
//		return "Record Inserted";
//
//	}

	@PutMapping("/response")
	public String performUpdate(@RequestBody Responses responses) {
		rsService.update(responses);
		return "Record Updated";
	}

	@DeleteMapping("/response/{responseId}")
	public void performDelete(@PathVariable("responseId") long responseId) {
		rsService.delete(responseId);
	}

	@GetMapping("/response")
	public List<Responses> viewAllResponses() {
		return rsService.getAllResponsesDetails();
	}
	
	@GetMapping("/getresponses/{surveyId}")
	public List<ResponsesDTO> viewResponses(@PathVariable("surveyId") long surveyId) {
		return rsService.getAllResponses(surveyId);
	}
	
	@GetMapping("/getresponsesbyresponsedetail/{responseDetailId}")
	public List<Responses> viewResponsesByResponseDetail(@PathVariable("responseDetailId") long responseDetailId) {
		return rsService.getByResponsesDetailId(responseDetailId);
	}

}
