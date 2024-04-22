package com.relevantz.ccp.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.relevantz.ccp.model.Options;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Component
public class QuestionsDTO {
	
	private long questionId;

	private long questionNo;

	private String questions;

	private String optionType;

	private long pageId;

	private List<Options> option;

	public QuestionsDTO() {
		super();
	}

	public QuestionsDTO(long questionId, long questionNo, String questions, String optionType, long pageId,
			List<Options> option) {
		super();
		this.questionId = questionId;
		this.questionNo = questionNo;
		this.questions = questions;
		this.optionType = optionType;
		this.pageId = pageId;
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

	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public List<Options> getOption() {
		return option;
	}

	public void setOption(List<Options> option) {
		this.option = option;
	}
	
	

}
