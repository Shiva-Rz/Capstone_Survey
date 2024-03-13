package com.ccp.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_response")
public class Responses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reponse_id")
	private long responseId;
	
	@Column(name="response_question")
	private String responseQuestion;
	
	@Column(name="response_answer")
	private String responseAnswer;
	
	public Responses() {
		super();
	}

	public Responses(long responseId, String responseQuestion, String responseAnswer) {
		super();
		this.responseId = responseId;
		this.responseQuestion = responseQuestion;
		this.responseAnswer = responseAnswer;
	}

	public long getResponseId() {
		return responseId;
	}

	public void setResponseId(long responseId) {
		this.responseId = responseId;
	}

	public String getResponseQuestion() {
		return responseQuestion;
	}

	public void setResponseQuestion(String responseQuestion) {
		this.responseQuestion = responseQuestion;
	}

	public String getResponseAnswer() {
		return responseAnswer;
	}

	public void setResponseAnswer(String responseAnswer) {
		this.responseAnswer = responseAnswer;
	}
	


}
