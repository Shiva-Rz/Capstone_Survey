package com.rts.ccp.bean;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_poll_option")
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long optionId;

	private String value;

	

//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "option_id")
//	private List<OptionResponse> optionResponse;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="poll_id")
	private Poll pollId;

	public Option() {
		super();
	}

	public Option(long optionId, String value,  Poll pollId) {
		super();
		this.optionId = optionId;
		this.value = value;
//		this.optionResponse = optionResponse;
		this.pollId = pollId;
	}



	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

//
//	public List<OptionResponse> getOptionResponse() {
//		return optionResponse;
//	}
//
//	public void setOptionResponse(List<OptionResponse> optionResponse) {
//		this.optionResponse = optionResponse;
//	}
//	

	public Poll getPollId() {
		return pollId;
	}

	public void setPollId(Poll pollId) {
		this.pollId = pollId;
	}



}
