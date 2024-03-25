package com.relevantz.ccp.model;

import java.sql.Time;


import java.util.List;

import org.springframework.stereotype.Component;

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
@Table(name="tbl_responsedetail")
@Component
public class ResponseDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reponsedetail_id")
	private long responseDetailId;
	
	@Column(name="useremail_id")
	private String userEmailId;
	
	@Column(name="start_time")
	private String startTime;
	
	@Column(name="end_time")
	private String endTime;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="responsedetail_id")
	private List<Responses> response;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User users;
	
	public ResponseDetails() {
		super();
	}

	

	


	public ResponseDetails(long responseDetailId, String userEmailId, String startTime, String endTime,
			List<Responses> response, User users) {
		super();
		this.responseDetailId = responseDetailId;
		this.userEmailId = userEmailId;
		this.startTime = startTime;
		this.endTime = endTime;
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

	
	
	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
