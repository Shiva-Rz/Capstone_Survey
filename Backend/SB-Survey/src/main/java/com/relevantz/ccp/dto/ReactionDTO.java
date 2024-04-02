package com.relevantz.ccp.dto;

public class ReactionDTO {
	
	private long surveyId;
	 
	private long userId;
	
	private long reactionCount;

	public ReactionDTO() {
		super();
	}

	public ReactionDTO(long surveyId, long userId, long reactionCount) {
		super();
		this.surveyId = surveyId;
		this.userId = userId;
		this.reactionCount = reactionCount;
	}





	public long getSurveyId() {
		return surveyId;
	}



	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getReactionCount() {
		return reactionCount;
	}

	public void setReactionCount(long reactionCount) {
		this.reactionCount = reactionCount;
	}
	
	
	
 

}
