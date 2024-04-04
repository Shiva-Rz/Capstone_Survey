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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_reaction")
@Component
public class Reaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reaction_id")
	private long reactionId;

	@Column(name = "reaction_value")
	private String reactionValue;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "symbol_id")
	private Symbol symbol;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User userId;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "survey_id")
	private Survey surveyId;

	public Reaction() {
		super();
	}

	public Reaction(long reactionId, String reactionValue, Symbol symbol, User userId, Survey surveyId) {
		super();
		this.reactionId = reactionId;
		this.reactionValue = reactionValue;
		this.symbol = symbol;
		this.userId = userId;
		this.surveyId = surveyId;
	}

	public long getReactionId() {
		return reactionId;
	}

	public void setReactionId(long reactionId) {
		this.reactionId = reactionId;
	}

	public String getReactionValue() {
		return reactionValue;
	}

	public void setReactionValue(String reactionValue) {
		this.reactionValue = reactionValue;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public Survey getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Survey surveyId) {
		this.surveyId = surveyId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

}
