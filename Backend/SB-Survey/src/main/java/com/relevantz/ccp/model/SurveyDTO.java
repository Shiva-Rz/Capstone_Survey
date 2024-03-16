package com.relevantz.ccp.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class SurveyDTO {
	
    private long surveyId;

	private String surveyName;
	
	private Date endDate;

	private String status;
	
	private List<Pages> page;
	
	private List<ResponseDetails> responseDetails;
	
	private List<Reaction> reaction;
	
	private List<Comment> comment;
	
	private User user;
	
	private long region;
	
	private long department;
	
	private long project;
	
	public SurveyDTO() {
		super();
	}

	



	public SurveyDTO(long surveyId, String surveyName, Date endDate, String status,
			List<Pages> page, List<ResponseDetails> responseDetails, List<Reaction> reaction, List<Comment> comment,
			User user, long region, long department, long project) {
		super();
		this.surveyId = surveyId;
		this.surveyName = surveyName;
		this.endDate = endDate;
		this.status = status;
		this.page = page;
		this.responseDetails = responseDetails;
		this.reaction = reaction;
		this.comment = comment;
		this.user = user;
		this.region = region;
		this.department = department;
		this.project = project;
	}





	public long getSurveyId() {
		return surveyId;
	}



	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}



	public String getSurveyName() {
		return surveyName;
	}



	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public List<Pages> getPage() {
		return page;
	}



	public void setPage(List<Pages> page) {
		this.page = page;
	}



	public List<ResponseDetails> getResponseDetails() {
		return responseDetails;
	}



	public void setResponseDetails(List<ResponseDetails> responseDetails) {
		this.responseDetails = responseDetails;
	}



	public List<Reaction> getReaction() {
		return reaction;
	}



	public void setReaction(List<Reaction> reaction) {
		this.reaction = reaction;
	}



	public List<Comment> getComment() {
		return comment;
	}



	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}





	public long getRegion() {
		return region;
	}





	public void setRegion(long region) {
		this.region = region;
	}





	public long getDepartment() {
		return department;
	}





	public void setDepartment(long department) {
		this.department = department;
	}





	public long getProject() {
		return project;
	}





	public void setProject(long project) {
		this.project = project;
	}



	
	
	
	
}
