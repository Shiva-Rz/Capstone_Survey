package com.rts.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Symbol;
import com.rts.ccp.repository.SymbolRepo;

@Service
public class SymbolService {

	@Autowired
	SymbolRepo symbolRepo;

	public boolean insertSymbol(Symbol symbol) {
		symbolRepo.save(symbol);
		return true;
	}

	public boolean updateSymbol(Symbol symbol) {
		symbolRepo.save(symbol);
		return true;
	}

	public boolean deleteSymbol(int symbolId) {
		symbolRepo.deleteById(symbolId);
		return true;
	}

	public List<Symbol> getAllSymbolDetails() {
		Iterator<Symbol> it = symbolRepo.findAll().iterator();
		ArrayList<Symbol> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
