package com.relevantz.ccp.service;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

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
	ResponsesDTO responsesDTO;
	
	@Autowired
	ResponseDetailsRepo resDetailRepo;

	public boolean insert(ResponsesDTO responsesdto) {
		
//		ArrayList<Responses> resList=new ArrayList<Responses>();
//		Iterator<Responses> it=responseDetails.getResponse().iterator();
		if((responsesdto.getOptionType()).equalsIgnoreCase("Radio")) {
//			System.out.println("a");
		Options options = opRepo.findById(responsesdto.getOptionId()).get();
		long opt = opRepo.findByOptionId(responsesdto.getOptionId());
		Questions question = qnRepo.findById(opt).get();
		ResponseDetails responseDetails=resDetailRepo.findById(responsesdto.getResponseDetailId()).get();
		responses.setResponseId(rsRepo.count() + 1);
		responses.setResponseAnswer(options.getOptions());
		responses.setResponseQuestion(question.getQuestions());
		responses.setResponseDetails(responseDetails);
		rsRepo.save(responses);
//		while(it.hasNext()) {
//			resList.add(it.next());
//		}
//		resList.add(responses);
////		rsRepo.save(responses);
		}
		else if ((responsesdto.getOptionType()).equalsIgnoreCase("Checkbox")) {
//			System.out.println("b");
			Iterator<Long> opIt=responsesdto.getOption().iterator();
			ArrayList<String> opList=new ArrayList<String>();
			Questions question=new Questions();
			String answer=new String();
			while(opIt.hasNext()) {
				Long lg=opIt.next();
                Options opt=opRepo.findById(lg).get();
                long qn=opRepo.findByOptionId(opt.getOptionId());
                question=qnRepo.findById(qn).get();
                String optn=opt.getOptions();
                opList.add(optn);
                String joiner=",";
                StringBuilder builder = new StringBuilder(); 
//                opList.forEach(joiner::add);
                for (String ch : opList) {  
                    builder.append(ch+joiner); 
                }  
                answer=builder.toString();
			}
			ResponseDetails responseDetails=resDetailRepo.findById(responsesdto.getResponseDetailId()).get();
			responses.setResponseId(rsRepo.count()+1);
			responses.setResponseQuestion(question.getQuestions());
			responses.setResponseAnswer(answer);
			responses.setResponseDetails(responseDetails);
			rsRepo.save(responses);
//			while(it.hasNext()) {
//				resList.add(it.next());
//			}
//			rsRepo.save(responses);
		}
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
	
	public List<Responses> getByReponsesDetailId(long responsedetailId) {
		Iterator<Responses> it = rsRepo.findByResponseDetailId(responsedetailId).iterator();
		ArrayList<Responses> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<Responses> getAllReponsesDetails() {
		Iterator<Responses> it = rsRepo.findAll().iterator();
		ArrayList<Responses> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public List<ResponsesDTO> getAllReponses(long surveyId) {
		Iterator<ResponseDetails> reDIt =resDetailRepo.findBySruveyId(surveyId).iterator();
		ArrayList<ResponsesDTO> list = new ArrayList<>();
		while (reDIt.hasNext()) {
			 ResponseDetails responseDetail=reDIt.next();
			 Iterator<Responses> reIt=rsRepo.findByResponseDetailId(responseDetail.getResponseDetailId()).iterator();
			 while(reIt.hasNext()) {
				 Responses responses=reIt.next();
				 ResponsesDTO responsesDTO=new ResponsesDTO();
				 responsesDTO.setResponsesId(responses.getResponseId());
				 responsesDTO.setResponseDetailId(responseDetail.getResponseDetailId());
				 responsesDTO.setResponseAnswer(responses.getResponseAnswer());
				 responsesDTO.setResponseQuestion(responses.getResponseQuestion());
				 list.add(responsesDTO);
			 }
			 
		}
		
		return list;
	}

}
