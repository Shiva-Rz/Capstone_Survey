package com.post.entity;

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
@Table(name="tbl_post_comment")
public class Comment {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
	 
		private String body;
		

		@ManyToOne(cascade=CascadeType.MERGE)
		@JoinColumn(name="user_id")
		private User user;
		

		@ManyToOne()
		@JoinColumn(name="post_id")
		private Post post;
	 
		private long parentId;
	 
		@jakarta.persistence.Column(nullable = false, updatable = false)
	    @jakarta.persistence.Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdAt;

		public Comment() {
			super();
		}

		public Comment(long id, String body, User user, Post post, long parentId, Date createdAt) {
			super();
			this.id = id;
			this.body = body;
			this.user = user;
			this.post = post;
			this.parentId = parentId;
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

		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
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
		
		
		
		
		
	}
	
	

