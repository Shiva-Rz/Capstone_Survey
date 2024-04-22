package com.rts.ccp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
 
import com.rts.ccp.bean.OptionResponse;
 
import jakarta.transaction.Transactional;
 
import com.rts.ccp.repository.OptionResponseRepo;
 
@Service
public class OptionResponseService {
 
	@Autowired
	private OptionResponseRepo optionResponseRepo;
 
	public OptionResponse createVote(int pollId, int optionId, int userId) {
 
		OptionResponse optionResponse = new OptionResponse();
		optionResponse.setOptionId(optionId);
		optionResponse.setPollId(pollId);
 
		optionResponse.setUserId(userId);
		return optionResponseRepo.save(optionResponse);
 
	}
 
	@Transactional
	public boolean updateReponseById( long optionId,long userId) {
		optionResponseRepo.updatebyId(optionId,userId);
		return true;
	}
}