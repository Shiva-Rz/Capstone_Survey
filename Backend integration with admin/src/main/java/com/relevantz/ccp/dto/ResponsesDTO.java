package com.relevantz.ccp.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponsesDTO {

	private long OptionId;
	
	private long responsesId;
	
	private List<Long> Option;  
	
	private String optionType;
	
	private long responseDetailId;
	
	private String responseAnswer;
	
	private String responseQuestion;

	public ResponsesDTO() {
		super();
	}
	
	public ResponsesDTO(long optionId, long responsesId, List<Long> option, String optionType, long responseDetailId,
			String responseAnswer, String responseQuestion) {
		super();
		OptionId = optionId;
		this.responsesId = responsesId;
		Option = option;
		this.optionType = optionType;
		this.responseDetailId = responseDetailId;
		this.responseAnswer = responseAnswer;
		this.responseQuestion = responseQuestion;
	}


    

	public long getResponsesId() {
		return responsesId;
	}

	public void setResponsesId(long responsesId) {
		this.responsesId = responsesId;
	}

	public long getOptionId() {
		return OptionId;
	}

	public void setOptionId(long optionId) {
		OptionId = optionId;
	}

	public List<Long> getOption() {
		return Option;
	}

	public void setOption(List<Long> option) {
		Option = option;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public long getResponseDetailId() {
		return responseDetailId;
	}

	public void setResponseDetailId(long responseDetailId) {
		this.responseDetailId = responseDetailId;
	}


	public String getResponseAnswer() {
		return responseAnswer;
	}


	public void setResponseAnswer(String responseAnswer) {
		this.responseAnswer = responseAnswer;
	}


	public String getResponseQuestion() {
		return responseQuestion;
	}


	public void setResponseQuestion(String responseQuestion) {
		this.responseQuestion = responseQuestion;
	}
	
	
	
	
	
	

}
