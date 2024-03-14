package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Options;
import com.relevantz.ccp.model.Pages;
import com.relevantz.ccp.model.Questions;
import com.relevantz.ccp.repository.PagesRepo;

@Service
public class PagesService {

	@Autowired
	PagesRepo pgRepo;
	
//	@Autowired 
//	Pages pages;
	
//	@Autowired
//	Questions questions;
	
//	@Autowired
//	Options options;
	
	public boolean insert(Pages pages) {
		pgRepo.save(pages);
		return true;
   }
	
	public boolean update(Pages pages) {
		pgRepo.save(pages);
		return true;
	}
	
	public boolean delete(long pageId) {
		pgRepo.deleteById(pageId);
		return true;
	}
	
	public List<Pages> getPages(long surveyId){
		Iterator<Pages> i=pgRepo.findBySurveyId(surveyId).iterator();
		ArrayList<Pages> arList=new ArrayList<>();
		while(i.hasNext()) {
			Pages pages=i.next();
			pages.getPageId();
			pages.getPageNo();
			pages.getPageTitle();
			Iterator<Questions> qList=pages.getQuestion().iterator();
			
			while(qList.hasNext()) {
				Questions questions=qList.next();
				questions.getQuestionId();
				questions.getQuestionNo();
				questions.getQuestions();
				Iterator<Options> opList=questions.getOption().iterator();
				
				while(opList.hasNext()) {
					Options options=opList.next();
					options.getOptionId();
					options.getOptions();
				}
				
			}
			arList.add(pages);
			
		}
		return arList;
		
	}
	
	public List<Pages> getAllPagesDetails(){
		Iterator<Pages> it=pgRepo.findAll().iterator();
		ArrayList<Pages> list=new ArrayList<>();
		while(it.hasNext()) {	
			list.add(it.next());
			
		}
		return list;
	}

}
