package com.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.survey.bean.Symbol;
import com.survey.service.SymbolService;

public class SymbolController {
	
	@Autowired
	 SymbolService slService;
	
	@PostMapping("/symbol")
	public String performInsert(@RequestBody Symbol symbol) {
		slService.insert(symbol);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/symbol")
	public String performUpdate(@RequestBody Symbol symbol) {
		slService.update(symbol);	
		return "Record Updated";
	}
	
	@DeleteMapping("/symbol/{symbolId}")
	public void performDelete(@PathVariable("symbolId") long symbolId) {
		slService.delete(symbolId);
	}
	
	@GetMapping("/symbol")
	public List<Symbol> viewAllSymbolDetails(){
		return slService.getAllSymbolDetails();
	}

}
