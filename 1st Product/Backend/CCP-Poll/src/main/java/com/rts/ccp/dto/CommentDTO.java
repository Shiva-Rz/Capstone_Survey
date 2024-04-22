package com.rts.ccp.dto;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CommentDTO {

	private long pollId;

	private Date createdAt;

	private String body;

	private long parentId;
	
	private long userId;
	
	public CommentDTO() {
		super();
	}

	

	public CommentDTO(long pollId, Date createdAt, String body, long parentId, long userId) {
		super();
		this.pollId = pollId;
		this.createdAt = createdAt;
		this.body = body;
		this.parentId = parentId;
		this.userId = userId;
	}



	public long getPollId() {
		return pollId;
	}

	public void setPollId(long pollId) {
		this.pollId = pollId;
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

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

}
