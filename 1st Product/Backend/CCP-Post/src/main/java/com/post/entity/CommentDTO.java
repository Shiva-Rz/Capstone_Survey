package com.post.entity;

import java.util.Date;

public class CommentDTO {
	
	private long postId;

	private Date createdAt;

	private String body;

	private long userId;

	private long parentId;

	public CommentDTO() {
		super();
	}

	public CommentDTO(long postId, Date createdAt, String body, long userId, long parentId) {
		super();
		
		this.postId = postId;
		this.createdAt = createdAt;
		this.body = body;
		this.userId = userId;
		this.parentId = parentId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
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