package com.rts.ccp.dto;
import java.sql.Date;
import java.util.List;

import com.rts.ccp.bean.Comment;
import com.rts.ccp.bean.Option;
import com.rts.ccp.bean.Reaction;
import com.rts.ccp.bean.User;

import jakarta.jws.soap.SOAPBinding.Use;
 
public class PollDTO {
	
	private long pollId;
	
	private String pollQuestion;
 
	private List<Option> options;
 
	private Date timeStamp;
 
	private Date endDate;
 
	private boolean status;
 
	private List<Reaction> reaction;
 
	private List<Comment> comments;
 
	private long user;
 
	private long region;
 
	private long department;
 
	private long project;
 
	public PollDTO() {
		super();
	}
 
	
	public PollDTO(long pollId, String pollQuestion, List<Option> options, Date timeStamp, Date endDate, boolean status,
			List<Reaction> reaction, List<Comment> comments, long user, long region, long department, long project) {
		super();
		this.pollId = pollId;
		this.pollQuestion = pollQuestion;
		this.options = options;
		this.timeStamp = timeStamp;
		this.endDate = endDate;
		this.status = status;
		this.reaction = reaction;
		this.comments = comments;
		this.user = user;
		this.region = region;
		this.department = department;
		this.project = project;
	}


	public String getPollQuestion() {
		return pollQuestion;
	}
 
	public void setPollQuestion(String pollQuestion) {
		this.pollQuestion = pollQuestion;
	}
 
	public List<Option> getOptions() {
		return options;
	}
 
	public void setOptions(List<Option> options) {
		this.options = options;
	}
 
	public Date getTimeStamp() {
		return timeStamp;
	}
 
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
 
	public Date getEndDate() {
		return endDate;
	}
 
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
 
	public boolean isStatus() {
		return status;
	}
 
	public void setStatus(boolean status) {
		this.status = status;
	}
 
	public List<Reaction> getReaction() {
		return reaction;
	}
 
	public void setReaction(List<Reaction> reaction) {
		this.reaction = reaction;
	}
 
	public List<Comment> getComments() {
		return comments;
	}
 
	public void setComments(List<Comment> comments) {
		this.comments = comments;
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


	public long getPollId() {
		return pollId;
	}


	public void setPollId(long pollId) {
		this.pollId = pollId;
	}
	
	
 
}