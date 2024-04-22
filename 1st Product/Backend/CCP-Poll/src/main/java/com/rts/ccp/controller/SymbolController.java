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

import com.rts.ccp.bean.Symbol;
import com.rts.ccp.service.SymbolService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SymbolController {

	@Autowired
	SymbolService symbolService;

	@PostMapping("/symbol")
	public String performSymbolInsert(@RequestBody Symbol symbol) {
		symbolService.insertSymbol(symbol);
		return "Symbol Inserted!";
	}

	@PutMapping("/symbol")
	public String performSymbolUpdate(@RequestBody Symbol symbol) {
		symbolService.updateSymbol(symbol);
		return "Symbol Updated!";
	}

	@DeleteMapping("/symbol/{symbolId}")
	public String performSymbolDelete(@PathVariable("symbolId") int symbolId) {
		symbolService.deleteSymbol(symbolId);
		return "Symbol Deleted!";
	}

	@GetMapping("/symbol")
	public List<Symbol> viewAllSymbolDetails() {
		return symbolService.getAllSymbolDetails();
	}

}
