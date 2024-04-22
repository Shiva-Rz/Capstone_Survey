package com.rts.ccp.dto;


public class OptionResponseDTO {

	private long optionId;
	private long pollId;

	public OptionResponseDTO() {
		super();
	}

	public OptionResponseDTO(long optionId, long pollId) {
		super();
		this.optionId = optionId;
		this.pollId = pollId;
	}

	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public long getPollId() {
		return pollId;
	}

	public void setPollId(long pollId) {
		this.pollId = pollId;
	}
	
	

}
