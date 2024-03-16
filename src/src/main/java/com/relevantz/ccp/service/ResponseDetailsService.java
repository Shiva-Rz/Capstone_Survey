package com.relevantz.ccp.service;

import java.util.ArrayList;
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

	public List<ResponseDetails> getAllResponseDetails() {
		Iterator<ResponseDetails> it = rdRepo.findAll().iterator();
		ArrayList<ResponseDetails> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public long getResponseDetailCount(long surveyId) {
		long value = rdRepo.getResponseDetailCount(surveyId);
		return value;
	}

}
