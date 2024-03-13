package com.ccp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ccp.bean.ResponseDetails;
import com.ccp.service.ResponseDetailsService;

public class ResponseDetailsController {
	
	@Autowired
	 ResponseDetailsService rdcService;
	
	@PostMapping("/responsedetail")
	public String performInsert(@RequestBody ResponseDetails responseDetails) {
		rdcService.insert(responseDetails);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/responsedetail")
	public String performUpdate(@RequestBody ResponseDetails responseDetails) {
		rdcService.update(responseDetails);	
		return "Record Updated";
	}
	
	@DeleteMapping("/responsedetail/{responseDetailId}")
	public void performDelete(@PathVariable("responseDetailId") long responseDetailId) {
		rdcService.delete(responseDetailId);
	}
	
	@GetMapping("/responsedetail")
	public List<ResponseDetails> viewAllResponseDetails(){
		return rdcService.getAllResponseDetails();
	}
	

}
