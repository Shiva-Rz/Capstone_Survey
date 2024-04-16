package com.relevantz.ccp.model;
//
////import java.util.List;
////
////import org.springframework.stereotype.Component;
////
////import com.fasterxml.jackson.annotation.JsonIgnore;
////
////import jakarta.persistence.CascadeType;
////import jakarta.persistence.Column;
////import jakarta.persistence.Entity;
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
////import jakarta.persistence.Id;
////import jakarta.persistence.JoinColumn;
////import jakarta.persistence.ManyToOne;
////import jakarta.persistence.OneToMany;
////import jakarta.persistence.Table;
////
////@Entity
////@Table(name = "tbl_comment")
////@Component
////public class Comment {
////
////	@Id
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	@Column(name = "comment_id")
////	private long commentId;
////
////	@Column(name = "comments")
////	private String comments;
//// 
////	@JsonIgnore
////	@ManyToOne(cascade = CascadeType.MERGE)
////	@JoinColumn(name = "user_id")
////	private User user;
////	
////	@JsonIgnore
////	@ManyToOne(cascade=CascadeType.MERGE)
////	@JoinColumn(name="survey_id")
////	private Survey survey;
////
////	public Comment() {
////		super();
////	}
////
////	
////
////	public Comment(long commentId, String comments, User user, Survey survey) {
////		super();
////		this.commentId = commentId;
////		this.comments = comments;
////		this.user = user;
////		this.survey = survey;
////	}
////
////
////
////	public long getCommentId() {
////		return commentId;
////	}
////
////	public void setCommentId(long commentId) {
////		this.commentId = commentId;
////	}
////
////	public String getComments() {
////		return comments;
////	}
////
////	public void setComments(String comments) {
////		this.comments = comments;
////	}
////
////	public User getUser() {
////		return user;
////	}
////
////	public void setUser(User user) {
////		this.user = user;
////	}
////
////
////
////	public Survey getSurvey() {
////		return survey;
////	}
////
////
////
////	public void setSurvey(Survey survey) {
////		this.survey = survey;
////	}
////	
////	
////
////}
//
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name="tbl_survey_comment")
public class Comment {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String body;
		
		@ManyToOne(cascade=CascadeType.MERGE)
		@JoinColumn(name="user_id")
		private User user;
		private long parentId;
		
		@ManyToOne
		@JoinColumn(name="survey_id")
		private Survey survey;
		
		@jakarta.persistence.Column(nullable = false, updatable = false)
	    @jakarta.persistence.Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;
 
		public Comment() {
			super();
		}
 
		
 
		public Comment(long id, String body, User user, long parentId, Survey survey, Date createdAt) {
			super();
			this.id = id;
			this.body = body;
			this.user = user;
			this.parentId = parentId;
			this.survey = survey;
			this.createdAt = createdAt;
		}



		public long getId() {
			return id;
		}
 
		public void setId(long id) {
			this.id = id;
		}
 
		public String getBody() {
			return body;
		}
 
		public void setBody(String body) {
			this.body = body;
		}
 
		public User getUser() {
			return user;
		}
 
		public void setUser(User user) {
			this.user = user;
		}
 
		public long getParentId() {
			return parentId;
		}
 
		public void setParentId(long parentId) {
			this.parentId = parentId;
		}
 
		public Date getCreatedAt() {
			return createdAt;
		}
 
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}



		public Survey getSurvey() {
			return survey;
		}



		public void setSurvey(Survey survey) {
			this.survey = survey;
		}
		
		

	}
