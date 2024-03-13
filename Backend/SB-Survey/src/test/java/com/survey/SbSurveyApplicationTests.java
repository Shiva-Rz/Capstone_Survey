package com.survey;

import static org.testng.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.survey.bean.Department;
import com.survey.bean.Options;
import com.survey.bean.Pages;
import com.survey.bean.Project;
import com.survey.bean.Questions;
import com.survey.bean.Region;
import com.survey.bean.Survey;
import com.survey.bean.User;
import com.survey.controller.ReponsesController;
import com.survey.controller.SurveyController;

@SpringBootTest
class SbSurveyApplicationTests {

	@Autowired
	SurveyController srController;
	
	
	@Test
	void performInsert() {
		Options option=new Options(1,"11"); 
		List<Options> opList=new ArrayList<>(); 
		opList.add(option); 

	    Questions question=new Questions(); 
        question.setQuestionId(1); 
        question.setQuestionNo(1); 
        question.setQuestions("What is 10+1 ?"); 
        question.setOption(opList); 

		 List<Questions> qList=new ArrayList<Questions>(); 
		 qList.add(question); 

		Pages page=new Pages(); 
		page.setPageId(1); 
		page.setPageNo(1); 
		page.setPageTitle("Survey Form"); 
		page.setQuestion(qList); 
		
		List<Pages> pgList=new ArrayList<Pages>(); 
		 pgList.add(page);
		 
		 Project project=new Project();
		 project.setProjectId(3);
		 project.setProjectName("CCP");
		 Date dat=new Date(24, 03, 11);
		 Date dat1=new Date(25, 05, 11);
		 project.setStartDate(dat);
		 project.setEndDate(dat1);
		 
		 List<Project> prList=new ArrayList();
		 prList.add(project);
		 
		 Department department=new Department(); 
		 department.setDepartmentId(4);
		 department.setDepartmentName("Admin");
		 department.setProjects(prList);
		 
		 List<Department> drList=new ArrayList();
		 drList.add(department);
		 
		 Region region=new Region();
		 region.setRegionId(1);
		 region.setRegionName("India");
		 region.setRegionLocation("Virudhunagar");
		 region.setRegionTimezone("IST");
		 region.setDepartments(drList);
		 
		 User user=new User();
		 user.setUserId(3);
		 user.setUserFirstName("Sara");
		 user.setUserLastName("A");
		 user.setUserEmailId("sara@gmail.com");
		 user.setUserPassword("sara@123");
		 user.setUserType("User");
		 user.setUserMobileNumber("7010866068");
		 user.setRegion(region);
		 
		
		 
		 
		 
		
		Survey survey=new Survey();
		survey.setSurveyId(1);
		survey.setSurveyName("Employee Survey");
		survey.setStatus("open");
		
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
//		Date date=new Date(2024-03-11);
		survey.setEndDate(date);
		survey.setUserEmailId("swetha@gmail.com");
		survey.setPage(pgList);
		survey.setResponseDetails(null);
		survey.setReaction(null);
		survey.setComment(null);
		survey.setUser(user);
		survey.setRegion(region);
		survey.setDepartment(department);
		survey.setProject(project);

	    String ref=srController.performInsert(survey); 
		String value="Record Inserted"; 
		
		assertEquals(ref, value);	 

	}
	
	

}


 
