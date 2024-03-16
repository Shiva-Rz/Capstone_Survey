package com.relevantz.ccp.service;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.ResponseDetails;
import com.relevantz.ccp.repository.ResponseDetailsRepo;

@Service
public class ResponseDetailsService {
	
	@Autowired
    ResponseDetailsRepo rdRepo;
	
	public boolean insert(ResponseDetails reponseDetails) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		reponseDetails.setStartTime(dateFormat.format(date));
		rdRepo.save(reponseDetails);
		return true;
   }
	
	public boolean update(ResponseDetails reponseDetails) {
		rdRepo.save(reponseDetails);
		return true;
	}
	
	public boolean delete(long reponseDetailId) {
		rdRepo.deleteById(reponseDetailId);
		return true;
	}
		
	public List<ResponseDetails> getAllResponseDetails(){
		Iterator<ResponseDetails> it=rdRepo.findAll().iterator();
		ArrayList<ResponseDetails> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

}
