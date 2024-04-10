package com.relevantz.ccp.dto;

import java.util.Date;

public class CommentDTO {
	
	private long id;
		
		private long surveyId;
	 
		private Date createdAt;
	 
		private String body;
	 
		private long userId;
		
		private long parentId;
		
		public CommentDTO() {
			super();
		}
	 
		public CommentDTO(long id,long surveyId, Date createdAt, String body,long userId,long parentId) {
			super();
			this.id = id;
			this.surveyId = surveyId;
			this.createdAt = createdAt;
			this.body = body;
			this.userId = userId;
			this.parentId = parentId;
		}
	 
		public long getId() {
			return id;
		}
	 
		public void setId(long id) {
			this.id = id;
		}
	 
		
	 
		public long getSurveyId() {
			return surveyId;
		}

		public void setSurveyId(long surveyId) {
			this.surveyId = surveyId;
		}

		public Date getCreatedAt() {
			return createdAt;
		}
	 
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
	 
		public String getBody() {
			return body;
		}
	 
		public void setBody(String body) {
			this.body = body;
		}
	 
		public long getUserId() {
			return userId;
		}
	 
		public void setUserId(long userId) {
			this.userId = userId;
		}
	 
		public long getParentId() {
			return parentId;
		}
	 
		public void setParentId(long parentId) {
			this.parentId = parentId;
		}
	
	

}
