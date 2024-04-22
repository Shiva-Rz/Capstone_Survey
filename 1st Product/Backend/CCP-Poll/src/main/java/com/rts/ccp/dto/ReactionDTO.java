package com.rts.ccp.dto;

public class ReactionDTO {

	private long pollId;
 
	private long userid;

	public long getPollId() {
		return pollId;
	}

	public void setPollId(long pollId) {
		this.pollId = pollId;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public ReactionDTO(long pollId, long userid) {
		super();
		this.pollId = pollId;
		this.userid = userid;
	}

	public ReactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OptionResponseDTO [pollId=" + pollId + ", userid=" + userid + "]";
	}
 	
	
}
