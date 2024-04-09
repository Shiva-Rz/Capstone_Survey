package com.relevantz.ccp.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_response")
@Component
public class Responses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reponse_id")
	private long responseId;

	@Column(name = "response_question")
	private String responseQuestion;

	@Column(name = "response_answer")
	private String responseAnswer;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="responsedetail_id")
	private ResponseDetails responseDetails;

	public Responses() {
		super();
	}

	public Responses(long responseId, String responseQuestion, String responseAnswer, ResponseDetails responseDetails) {
		super();
		this.responseId = responseId;
		this.responseQuestion = responseQuestion;
		this.responseAnswer = responseAnswer;
		this.responseDetails = responseDetails;
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

	public ResponseDetails getResponseDetails() {
		return responseDetails;
	}

	public void setResponseDetails(ResponseDetails responseDetails) {
		this.responseDetails = responseDetails;
	}
	
	

}
