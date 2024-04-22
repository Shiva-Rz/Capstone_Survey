package com.rts.ccp.bean;

 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "tbl_option_response")
public class OptionResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
	
	@Column(name = "poll_id")
	private int pollId;
 
	
	@Column(name = "option_id")
	private int optionId;
	
	@Column(name = "user_id")
	private int userId;
 
	public OptionResponse() {
		super();
	}	
	
	public OptionResponse(Long id, int pollId, int optionId, int userId) {
		super();
		this.id = id;
		this.pollId = pollId;
		this.optionId = optionId;
		this.userId = userId;
	}
 
 
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public int getPollId() {
		return pollId;
	}
 
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}
 
	public int getOptionId() {
		return optionId;
	}
 
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
 
	public int getUserId() {
		return userId;
	}
 
	public void setUserId(int userId) {
		this.userId = userId;
	}
 
	
	
	
	
 
}