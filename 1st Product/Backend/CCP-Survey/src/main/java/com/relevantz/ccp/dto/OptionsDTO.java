package com.relevantz.ccp.dto;

import jakarta.persistence.Column;

public class OptionsDTO {

	private long optionId;

	private String options;
	
	private long questionId;

	public OptionsDTO() {
		super();
	}

	public OptionsDTO(long optionId, String options, long questionId) {
		super();
		this.optionId = optionId;
		this.options = options;
		this.questionId = questionId;
	}

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	
}
