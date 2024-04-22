package com.post.entity;

public class ReactionDTO {
	
	private long postId;
	 
	private long userId;

	public ReactionDTO() {
		super();
	
	}

	public ReactionDTO(long postId, long userId) {
		super();
		this.postId = postId;
		this.userId = userId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

}
