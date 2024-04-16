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
@Table(name = "tbl_survey_option")
@Component
public class Options {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "option_Id")
	private long optionId;

	@Column(name = "options")
	private String options;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="question_id")
	private Questions question;
	

	public Options() {
		super();
	}

	

	public Options(long optionId, String options, Questions question) {
		super();
		this.optionId = optionId;
		this.options = options;
		this.question = question;
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



	public Questions getQuestion() {
		return question;
	}



	public void setQuestion(Questions question) {
		this.question = question;
	}
	
	

}
