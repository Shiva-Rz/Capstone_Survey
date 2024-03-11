package com.survey;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.survey.bean.Options;
import com.survey.bean.Pages;
import com.survey.bean.Questions;
import com.survey.controller.PageController;

@SpringBootTest
class SbSurveyApplicationTests {

	@Autowired
	PageController pgController;
	
	@Test
	@Order(1)
	void performInsert() {
		Options option=new Options(3,"9");
		Options option1=new Options(4,"11");
		List<Options> opList=new ArrayList<>();
		opList.add(option);
		opList.add(option1);
		
		Questions question=new Questions();
		question.setQuestionId(2);
		question.setQuestionNo(1);
		question.setQuestions("What is 10+1 ?");
		question.setOptionType("Single choice");
		question.setOption(opList);
		
		List<Questions> qList=new ArrayList<Questions>();
		qList.add(question);
		
		Pages page=new Pages();
		page.setPageId(2);
		page.setPageNo(1);
		page.setPageTitle("Survey Form");
		page.setQuestion(qList);
		
		String ref=pgController.performInsert(page);
		String value="Record Inserted";
		
		assertEquals(ref, value);	
		
	}
	
	@Test
	@Order(2)
	void performUpdate() {
		Options option=new Options(3,"Yes");
		Options option1=new Options(4,"No");
		List<Options> opList=new ArrayList<>();
		opList.add(option);
		opList.add(option1);
		
		Questions question=new Questions();
		question.setQuestionId(2);
		question.setQuestionNo(1);
		question.setQuestions("Does the sun color is yellow?");
		question.setOptionType("Single choice");
		question.setOption(opList);
		
		List<Questions> qList=new ArrayList<Questions>();
		qList.add(question);
		
		Pages page=new Pages();
		page.setPageId(2);
		page.setPageNo(1);
		page.setPageTitle("Survey Form");
		page.setQuestion(qList);
		
		String ref=pgController.performUpdate(page);
		String value="Record Updated";
		
		assertEquals(ref, value);	
		
	}
	
}
