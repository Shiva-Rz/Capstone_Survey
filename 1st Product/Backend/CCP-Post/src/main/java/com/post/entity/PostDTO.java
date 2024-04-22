package com.post.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PostDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;

	private String postContent;

	private String postImage;

	private Date dateTime;

	private boolean status;

	private List<Comment> comments;

	private List<Reactions> reactions;

	private List<Share> share;

	private List<Tags> tags;

	private long user;

	private long region;

	private long department;

	private long project;

	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDTO(long postId, String postContent, String postImage, Date dateTime, boolean status,
			 List<Comment> comments, List<Reactions> reactions, List<Share> share,
			List<Tags> tags, long user, long region, long department, long project) {
		super();
		this.postId = postId;
		this.postContent = postContent;
		this.postImage = postImage;
		this.dateTime = dateTime;
		this.status = status;
		this.comments = comments;
		this.reactions = reactions;
		this.share = share;
		this.tags = tags;
		this.user = user;
		this.region = region;
		this.department = department;
		this.project = project;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostImage() {
		return postImage;
	}

	public void setPostImage(String postImage) {
		this.postImage = postImage;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Reactions> getReactions() {
		return reactions;
	}

	public void setReactions(List<Reactions> reactions) {
		this.reactions = reactions;
	}

	public List<Share> getShare() {
		return share;
	}

	public void setShare(List<Share> share) {
		this.share = share;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public long getUser() {
		return user;
	}

	public void setUser(long user) {
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
