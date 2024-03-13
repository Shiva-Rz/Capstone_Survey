package com.survey.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.bean.Options;
import com.survey.repo.OptionRepo;

@Service	
public class OptionService {
	
	
	@Autowired
    OptionRepo opRepo;
	
	public boolean insert(Options options) {
		opRepo.save(options);
		return true;
   }
	
	public boolean update(Options options) {
		opRepo.save(options);
		return true;
	}
	
	public boolean delete(long optionsId) {
		opRepo.deleteById(optionsId);
		return true;
	}
		
	public List<Options> getAllOptionsDetails(){
		Iterator<Options> it=opRepo.findAll().iterator();
		ArrayList<Options> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}	


}
