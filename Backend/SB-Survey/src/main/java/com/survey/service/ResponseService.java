package com.survey.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.survey.bean.Responses;
import com.survey.repo.ResponseRepo;

@Service
public class ResponseService {
	
	@Autowired
    ResponseRepo rsRepo;
	
	public boolean insert(Responses responses) {
		rsRepo.save(responses);
		return true;
   }
	
	public boolean update(Responses responses) {
		rsRepo.save(responses);
		return true;
	}
	
	public boolean delete(long reponseId) {
		rsRepo.deleteById(reponseId);
		return true;
	}
		
	public List<Responses> getAllReponsesDetails(){
		Iterator<Responses> it=rsRepo.findAll().iterator();
		ArrayList<Responses> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}


}
