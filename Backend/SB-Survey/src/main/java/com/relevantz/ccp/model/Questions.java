package com.relevantz.ccp.model;

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
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_question")
@Component
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private long questionId;
	
	@Column(name="question_no")
	private long questionNo;
	
	@Column(name="questions")
	private String questions;
	
	@Column(name="option_type")
	private String optionType;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="question_id")
	private List<Options> option;
	
	public Questions() {
		super();
	}
	
	public Questions(long questionId, long questionNo, String questions, String optionType, List<Options> option) {
		super();
		this.questionId = questionId;
		this.questionNo = questionNo;
		this.questions = questions;
		this.optionType = optionType;
		this.option = option;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public long getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(long questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public List<Options> getOption() {
		return option;
	}

	public void setOption(List<Options> option) {
		this.option = option;
	}
	
	
}
