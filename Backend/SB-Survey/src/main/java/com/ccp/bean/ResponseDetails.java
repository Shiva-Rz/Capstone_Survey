package com.ccp.bean;

import java.sql.Time;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tbl_reponsedetail")
public class ResponseDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reponsedetail_id")
	private long responseDetailId;
	
	@Column(name="useremail_id")
	private String userEmailId;
	
	@Column(name="start_time")
	private Time startTime;
	
	@Column(name="end_time")
	private Time endTime;
	
	@Column(name="duration")
	private Time duration;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="responsedetail_id")
	private List<Responses> response;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User users;
	
	public ResponseDetails() {
		super();
	}

	public ResponseDetails(long responseDetailId, String userEmailId, Time startTime, Time endTime, Time duration,
			List<Responses> response, User users) {
		super();
		this.responseDetailId = responseDetailId;
		this.userEmailId = userEmailId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.response = response;
		this.users = users;
	}

	public long getResponseDetailId() {
		return responseDetailId;
	}

	public void setResponseDetailId(long responseDetailId) {
		this.responseDetailId = responseDetailId;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public List<Responses> getResponse() {
		return response;
	}

	public void setResponse(List<Responses> response) {
		this.response = response;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	
	
	
	

}
