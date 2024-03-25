package com.relevantz.ccp.dto;

public class CommentDTO {
	
	private long commentId;

	private String comments;

	private long user;
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(long commentId, String comments, long user) {
		super();
		this.commentId = commentId;
		this.comments = comments;
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

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
		this.user = user;
	}

	
	
	
	
	

}
