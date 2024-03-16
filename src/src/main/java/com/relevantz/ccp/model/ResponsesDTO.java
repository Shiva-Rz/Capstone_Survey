package com.relevantz.ccp.model;

public class ResponsesDTO {

	private long OptionId;

	public ResponsesDTO() {
		super();
	}

	public ResponsesDTO(long optionId) {
		super();
		OptionId = optionId;
	}

	public long getOptionId() {
		return OptionId;
	}

	public void setOptionId(long optionId) {
		OptionId = optionId;
	}

}
