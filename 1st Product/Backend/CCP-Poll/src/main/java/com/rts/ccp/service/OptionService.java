package com.rts.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Option;
import com.rts.ccp.dto.OptionDTO;
import com.rts.ccp.bean.Poll;
import com.rts.ccp.repository.OptionRepo;
import com.rts.ccp.repository.PollRepo;

@Service
public class OptionService {

	@Autowired
	OptionRepo optionRepo;

	@Autowired
	PollRepo pollrepo;
	
	public boolean insertOption(Option option) {
		optionRepo.save(option);
		return true;
	}

	public boolean updateOption(Option option) {
		optionRepo.save(option);
		return true;
	}

	public boolean deleteOption(long optionId) {
		optionRepo.deleteById(optionId);
		return true;
	}

	public List<Option> getAllOptionDetails() {
		Iterator<Option> it = optionRepo.findAll().iterator();
		ArrayList<Option> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<OptionDTO> optionsDetails() {
		Iterator<Option> it = optionRepo.findAll().iterator();
		ArrayList<OptionDTO> lists = new ArrayList<>();
		while (it.hasNext()) {
//			lists.add(it.next());
			Option opt=it.next();
			Poll poll=opt.getPollId();
			OptionDTO optdto =  new OptionDTO();
			optdto.setOptionId(opt.getOptionId());
			optdto.setPollId(poll.getPollId());
			optdto.setValue(opt.getValue());
			lists.add(optdto);
		}
		return lists;
	}
}
