package com.relevantz.ccp.dto;

public class ReactionDTO {
	
	private long surveyId;
	 
	private long userId;
	
	

	public ReactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ReactionDTO(long surveyId, long userId) {
		super();
		this.surveyId = surveyId;
		this.userId = userId;
	}



	public long getSurveyId() {
		return surveyId;
	}



	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
 

}
