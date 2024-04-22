package com.relevantz.ccp.dto;

import java.util.List;

import com.relevantz.ccp.model.Responses;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class ResponseDetailsDTO {

	
    private long responseDetailId;
	
	private String userEmailId;
	
	private String startTime;
	
	private String endTime;
	
	private List<Responses> response;
	
	private long userId;
	
	private String userName;
	
	private long surveyId;
	
	private long responseDetailCount;

	public ResponseDetailsDTO() {
		super();
	}


	public ResponseDetailsDTO(long responseDetailId, String userEmailId, String startTime, String endTime,
			List<Responses> response, long userId, String userName, long surveyId, long responseDetailCount) {
		super();
		this.responseDetailId = responseDetailId;
		this.userEmailId = userEmailId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.response = response;
		this.userId = userId;
		this.userName = userName;
		this.surveyId = surveyId;
		this.responseDetailCount = responseDetailCount;
	}







	public long getResponseDetailId() {
		return responseDetailId;
	}

	public void setResponseDetailId(long responseDetailId) {
		this.responseDetailId = responseDetailId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<Responses> getResponse() {
		return response;
	}

	public void setResponse(List<Responses> response) {
		this.response = response;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public long getSurveyId() {
		return surveyId;
	}



	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}


	public long getResponseDetailCount() {
		return responseDetailCount;
	}


	public void setResponseDetailCount(long responseDetailCount) {
		this.responseDetailCount = responseDetailCount;
	}
	
	
	
	
	
}
