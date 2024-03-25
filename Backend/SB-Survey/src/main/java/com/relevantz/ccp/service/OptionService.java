package com.relevantz.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Options;
import com.relevantz.ccp.model.OptionsDTO;
import com.relevantz.ccp.model.Pages;
import com.relevantz.ccp.model.Questions;
import com.relevantz.ccp.repository.OptionRepo;
import com.relevantz.ccp.repository.PagesRepo;
import com.relevantz.ccp.repository.QuestionsRepo;

@Service
public class OptionService {

	@Autowired
	OptionRepo opRepo;

	@Autowired

	PagesRepo pgRepo;

	@Autowired

	QuestionsRepo qnRepo;

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

	public List<Options> getAllOptionsDetails() {
		Iterator<Options> it = opRepo.findAll().iterator();
		ArrayList<Options> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<OptionsDTO> getAllOptions(long surveyId) {
		Iterator<Pages> pIt = pgRepo.findBySurveyId(surveyId).iterator();
		ArrayList<OptionsDTO> opList = new ArrayList<>();
		while (pIt.hasNext()) {
//			list.add(it.next());
			Pages pages = pIt.next();
			Iterator<Questions> qIt = qnRepo.findByPageId(pages.getPageId()).iterator();
			while (qIt.hasNext()) {
				Questions question = qIt.next();
				Iterator<Options> opIt = opRepo.findByQuestionId(question.getQuestionId()).iterator();
				while (opIt.hasNext()) {
					Options options=opIt.next();
					OptionsDTO optionsDTO=new OptionsDTO();
					optionsDTO.setOptionId(options.getOptionId());
					optionsDTO.setOptions(options.getOptions());
					optionsDTO.setQuestionId(question.getQuestionId());
					opList.add(optionsDTO);
				}
			}
		}
		return opList;
	}
}
