package com.relevantz.ccp.service;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.ResponsesDTO;
import com.relevantz.ccp.model.Options;
import com.relevantz.ccp.model.Questions;
import com.relevantz.ccp.model.ResponseDetails;
import com.relevantz.ccp.model.Responses;
import com.relevantz.ccp.repository.OptionRepo;
import com.relevantz.ccp.repository.QuestionsRepo;
import com.relevantz.ccp.repository.ResponseDetailsRepo;
import com.relevantz.ccp.repository.ResponseRepo;

@Service
public class ResponseService {

	@Autowired
	ResponseRepo rsRepo;

	@Autowired
	OptionRepo opRepo;

	@Autowired
	QuestionsRepo qnRepo;

	@Autowired
	Responses responses;
	
	@Autowired
	ResponseDetailsRepo resDetailRepo ;

	public boolean insert(ResponsesDTO responsesdto) {

		Options options = opRepo.findById(responsesdto.getOptionId()).get();
		long opt = opRepo.findByOptionId(responsesdto.getOptionId());
		Questions question = qnRepo.findById(opt).get();
		responses.setResponseId(rsRepo.count() + 1);
		responses.setResponseAnswer(options.getOptions());
		responses.setResponseQuestion(question.getQuestions());
		rsRepo.save(responses);
		return true;

	}
	
//	public boolean insertList(ResponsesDTO responsesdto) {
//        
//		
//		Iterator<Integer> it=responsesdto.getOption().iterator();
//		while(it.hasNext()) {
//			Integer a=it.next();
//			System.out.println(a);
//		}
////		Options options = opRepo.findById(responsesdto.getOptionId()).get();
////		long opt = opRepo.findByOptionId(responsesdto.getOptionId());
////		Questions question = qnRepo.findById(opt).get();
////		responses.setResponseId(rsRepo.count() + 1);
////		responses.setResponseAnswer(options.getOptions());
////		responses.setResponseQuestion(question.getQuestions());
////		rsRepo.save(responses);
//		return true;
//
//	}

	public boolean update(Responses responses) {
		rsRepo.save(responses);
		return true;
	}

	public boolean delete(long reponseId) {
		rsRepo.deleteById(reponseId);
		return true;
	}

	public List<Responses> getAllReponsesDetails() {
		Iterator<Responses> it = rsRepo.findAll().iterator();
		ArrayList<Responses> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public List<Responses> getAllReponses(long surveyId) {
		Iterator<ResponseDetails> reDIt =resDetailRepo.findBySruveyId(surveyId).iterator();
		ArrayList<Responses> list = new ArrayList<>();
		while (reDIt.hasNext()) {
			 ResponseDetails responseDetail=reDIt.next();
			 Iterator<Responses> reIt=rsRepo.findByResponseDetailId(responseDetail.getResponseDetailId()).iterator();
			 while(reIt.hasNext()) {
				 list.add(reIt.next());
			 }
		}
		return list;
	}

}
