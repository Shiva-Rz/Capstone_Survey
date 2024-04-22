package com.rts.ccp.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_poll_reaction")
public class Reaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reactionId;
//	
//	@OneToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "symbol_id")
//	private Symbol symbol;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User userId;

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="poll_id")
	private Poll pollId;
	
	public Reaction() {
		super();
	}

	public Reaction(long reactionId, User userId, Poll pollId) {
		super();
		this.reactionId = reactionId;
//		this.symbol = symbol;
		this.userId = userId;
		this.pollId = pollId;
	}

	public long getReactionId() {
		return reactionId;
	}

	public void setReactionId(long reactionId) {
		this.reactionId = reactionId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Poll getPollId() {
		return pollId;
	}

	public void setPollId(Poll pollId) {
		this.pollId = pollId;
	}

//	public Symbol getSymbol() {
//		return symbol;
//	}
//
//	public void setSymbol(Symbol symbol) {
//		this.symbol = symbol;
//	}


}
