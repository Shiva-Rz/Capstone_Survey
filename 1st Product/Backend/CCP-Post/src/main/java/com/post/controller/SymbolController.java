package com.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.entity.Symbol;
import com.post.service.SymbolService;
@RestController
@CrossOrigin("http://localhost:4200/") 
public class SymbolController {
	
	@Autowired(required = true)
	SymbolService symbolservice;

	@PostMapping("/Symbol")
	public boolean shareInsert(@RequestBody Symbol symbol) {
		symbolservice.addSymbol(symbol);
		return true;
	}

	@PutMapping("/Symbol")
	public boolean shareUpdate(@RequestBody Symbol symbol) {
		symbolservice.updateSymbol(symbol);
		return true;
	}

	@DeleteMapping("/Symbol/{symbolId}")
	public void performDelete(@RequestBody long symbolId) {
		symbolservice.deleteSymbol(symbolId);

	}

	@GetMapping("/Symbol")
	public List<Symbol> viewAllSymbolDetails() {
		return symbolservice.getAllSymbolDetails();

	}

}
