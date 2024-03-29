package com.relevantz.ccp.dto;

import java.util.List;

public class ResponsesDTO {

	private long OptionId;
	
	private List<Integer> Option;  
	
	private String optionType;

	public ResponsesDTO() {
		super();
	}
	
	public ResponsesDTO(long optionId, List<Integer> option, String optionType) {
		super();
		OptionId = optionId;
		Option = option;
		this.optionType = optionType;
	}


	public long getOptionId() {
		return OptionId;
	}

	public void setOptionId(long optionId) {
		OptionId = optionId;
	}

	public List<Integer> getOption() {
		return Option;
	}

	public void setOption(List<Integer> option) {
		Option = option;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	
	
	
	

}
