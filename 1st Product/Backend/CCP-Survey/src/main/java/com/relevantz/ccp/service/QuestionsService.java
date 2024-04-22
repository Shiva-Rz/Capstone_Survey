package com.relevantz.ccp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.QuestionsDTO;
import com.relevantz.ccp.model.Pages;
import com.relevantz.ccp.model.Questions;
import com.relevantz.ccp.repository.PagesRepo;
import com.relevantz.ccp.repository.QuestionsRepo;

@Service
public class QuestionsService {
	
	@Autowired
	QuestionsRepo qsRepo;
	
	@Autowired
	PagesRepo pgRepo ;
	
	public boolean insert(Questions questions) {
		qsRepo.save(questions);
		return true;
   }
	
	public boolean update(Questions questions) {
		qsRepo.save(questions);
		return true;
	}
	
	public boolean delete(long questionsId) {
		qsRepo.deleteById(questionsId);
		return true;
	}
	
//	public List<Survey> getSurveyDetails(String surveyName) {
//		Iterator<Survey> it1=crrepo.findBySurveyName(surveyName).iterator();
//		ArrayList<Survey> surveyList=new ArrayList<>();
//		while(it1.hasNext()) {
//			surveyList.add(it1.next());
//		}
//		return surveyList;
//	}
	
	public List<QuestionsDTO> getQuestion(long surveyId){
		Iterator<Pages> it=pgRepo.findBySurveyId(surveyId).iterator();
		ArrayList<QuestionsDTO> list=new ArrayList<>();
		while(it.hasNext()) {
//			list.add(it.next());
			Pages pages=it.next();
			Iterator<Questions> qIt=qsRepo.findByPageId(pages.getPageId()).iterator();
			while(qIt.hasNext()) {
				Questions question=qIt.next();
				QuestionsDTO questionsDTO=new QuestionsDTO();
				questionsDTO.setQuestionId(question.getQuestionId());
				questionsDTO.setQuestionNo(question.getQuestionNo());
				questionsDTO.setQuestions(question.getQuestions());
				questionsDTO.setOptionType(question.getOptionType());
				questionsDTO.setOption(question.getOption());
				questionsDTO.setPageId(pages.getPageId());
				list.add(questionsDTO);
				}
			
		}
		return list;
	}
	
	public List<Questions> getQuestionByPageId(long pageId){
//		Iterator<Pages> it=pgRepo.findBySurveyId(surveyId).iterator();
		ArrayList<Questions> list=new ArrayList<>();
//		while(it.hasNext()) {
////			list.add(it.next());
			
			Iterator<Questions> qIt=qsRepo.findByPageId(pageId).iterator();
			while(qIt.hasNext()) {
				list.add(qIt.next());
			
		}
		return list;
	}
	
	public List<Questions> getAllQuestionsDetails(){
		Iterator<Questions> it=qsRepo.findAll().iterator();
		ArrayList<Questions> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

}
