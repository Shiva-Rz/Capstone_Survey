package com.post.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.Symbol;
import com.post.repository.SymbolRepo;
@Service
public class SymbolService {
	
	@Autowired
	SymbolRepo symbolrepo;

	public boolean addSymbol(Symbol symbol) {
		symbolrepo.save(symbol);
		return true;
	}
	
	public boolean updateSymbol(Symbol symbol) {
		symbolrepo.save(symbol);
		return true;
	}
	
	public boolean deleteSymbol(long symbolId) {
		symbolrepo.deleteById(symbolId);
		return true;
	}
	
	public List<Symbol> getAllSymbolDetails() {
		Iterator<Symbol> it=symbolrepo.findAll().iterator();
		ArrayList<Symbol> list = new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

}
