package com.relevantz.ccp.model;

import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_page")
@Component
public class Pages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "page_Id")
	private long pageId;

	@Column(name = "page_no")
	private long pageNo;

	@Column(name = "page_title")
	private String pageTitle;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "page_id")
	private List<Questions> question;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="survey_id")
	private Survey survey;

	public Pages() {
		super();
	}

	

	public Pages(long pageId, long pageNo, String pageTitle, List<Questions> question, Survey survey) {
		super();
		this.pageId = pageId;
		this.pageNo = pageNo;
		this.pageTitle = pageTitle;
		this.question = question;
		this.survey = survey;
	}



	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public List<Questions> getQuestion() {
		return question;
	}

	public void setQuestion(List<Questions> question) {
		this.question = question;
	}



	public Survey getSurvey() {
		return survey;
	}



	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	

}
