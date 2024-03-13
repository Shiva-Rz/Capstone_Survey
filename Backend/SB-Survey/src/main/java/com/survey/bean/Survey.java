package com.survey.bean;

import java.sql.Date;


import java.util.List;

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
@Table(name="tbl_survey")
public class Survey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="survey_id")
	private long surveyId;
	
	@Column(name="survey_name")
	private String surveyName;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="useremail_id")
	private String userEmailId;
	
	@Column(name="status")
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="survey_id")
	private List<Pages> page;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="survey_id")
	private List<ResponseDetails> responseDetails;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="survey_id")
	private List<Reaction> reaction;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="survey_id")
	private List<Comment> comment;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="region_id")
	private Region region;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="department_id")
	private Department department;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="project_id")
	private Project project;
	
	public Survey() {
		super();
	}

	public Survey(long surveyId, String surveyName, Date endDate, String userEmailId, String status, List<Pages> page,
			List<ResponseDetails> responseDetails, List<Reaction> reaction, List<Comment> comment, User user,
			Region region, Department department, Project project) {
		super();
		this.surveyId = surveyId;
		this.surveyName = surveyName;
		this.endDate = endDate;
		this.userEmailId = userEmailId;
		this.status = status;
		this.page = page;
		this.responseDetails = responseDetails;
		this.reaction = reaction;
		this.comment = comment;
		this.user = user;
		this.region = region;
		this.department = department;
		this.project = project;
	}

	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Pages> getPage() {
		return page;
	}

	public void setPage(List<Pages> page) {
		this.page = page;
	}

	public List<ResponseDetails> getResponseDetails() {
		return responseDetails;
	}

	public void setResponseDetails(List<ResponseDetails> responseDetails) {
		this.responseDetails = responseDetails;
	}

	public List<Reaction> getReaction() {
		return reaction;
	}

	public void setReaction(List<Reaction> reaction) {
		this.reaction = reaction;
	}
	
	

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	

	
	
	
}
