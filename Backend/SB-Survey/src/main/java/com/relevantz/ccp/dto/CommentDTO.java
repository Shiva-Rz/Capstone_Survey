package com.relevantz.ccp.dto;

public class CommentDTO {
	
	private long commentId;

	private String comments;
	
	private long surveyId;
	
	private long userId;

	private String user;
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(long commentId, String comments, long surveyId, long userId, String user) {
		super();
		this.commentId = commentId;
		this.comments = comments;
		this.surveyId = surveyId;
		this.userId = userId;
		this.user = user;
	}







	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
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
