package com.rts.ccp.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class OptionDTO {
	
	private long optionId;

	private String value;


//	private List<OptionResponse> optionResponse;

	private long pollId;

	public OptionDTO() {
		super();
	}

	public OptionDTO(long optionId, String value, long pollId) {
		super();
		this.optionId = optionId;
		this.value = value;
	
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


	public long getPollId() {
		return pollId;
	}

	public void setPollId(long pollId) {
		this.pollId = pollId;
	}
	
	
	


}
