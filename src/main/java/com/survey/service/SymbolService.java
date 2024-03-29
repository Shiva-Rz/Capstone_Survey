package com.survey.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.bean.Symbol;
import com.survey.repo.SymbolRepo;

@Service
public class SymbolService {
	
	@Autowired
	SymbolRepo slRepo;
	
	public boolean insert(Symbol symbol) {
		slRepo.save(symbol);
		return true;
   }
	
	public boolean update(Symbol symbol) {
		slRepo.save(symbol);
		return true;
	}
	
	public boolean delete(long symbolId) {
		slRepo.deleteById(symbolId);
		return true;
	}
	
	public List<Symbol> getAllSymbolDetails(){
		Iterator<Symbol> it=slRepo.findAll().iterator();
		ArrayList<Symbol> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	

}
