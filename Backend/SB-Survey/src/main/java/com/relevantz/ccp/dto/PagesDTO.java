package com.relevantz.ccp.dto;

import java.util.List;

import com.relevantz.ccp.model.Questions;

public class PagesDTO {
	
	private long pageId;

	private long pageNo;

	private String pageTitle;

	private List<Questions> question;
	
	private long surveyId;

	public PagesDTO() {
		super();
	}

	public PagesDTO(long pageId, long pageNo, String pageTitle, List<Questions> question, long surveyId) {
		super();
		this.pageId = pageId;
		this.pageNo = pageNo;
		this.pageTitle = pageTitle;
		this.question = question;
		this.surveyId = surveyId;
	}

	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public List<Questions> getQuestion() {
		return question;
	}

	public void setQuestion(List<Questions> question) {
		this.question = question;
	}

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

}
