package com.rts.ccp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Department;
import com.rts.ccp.bean.Option;
import com.rts.ccp.bean.Poll;
import com.rts.ccp.dto.OptionDTO;
import com.rts.ccp.dto.PollDTO;
import com.rts.ccp.bean.Project;
import com.rts.ccp.bean.Region;
import com.rts.ccp.bean.User;
import com.rts.ccp.repository.DepartmentRepo;
import com.rts.ccp.repository.OptionRepo;
import com.rts.ccp.repository.PollRepo;
import com.rts.ccp.repository.ProjectRepo;
import com.rts.ccp.repository.RegionRepo;
import com.rts.ccp.repository.UserRepo;

@Service
public class PollService {

	@Autowired
	RegionRepo rgRepo;
 
	@Autowired
	DepartmentRepo dtRepo;
 
	@Autowired
	ProjectRepo ptRepo;
 
	@Autowired
	Region region;
 
	@Autowired
	Department department;
 
	@Autowired
	Project project;
	
	@Autowired
	PollRepo pollRepo;
	
	@Autowired
	User user;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	OptionRepo optionRepo;

//	public boolean insertPoll(Poll poll) {
//		pollRepo.save(poll);
//		return true;
//	}

	public void updatePoll(PollDTO poll) {
		Poll newPoll = pollRepo.findById(poll.getPollId()).get();
		
		
		
		newPoll.setPollId(poll.getPollId());
		newPoll.setStatus(poll.isStatus());
		
		pollRepo.save(newPoll);
		System.out.println("updated");
	
		
	}

	public boolean insertPoll(PollDTO pollDto) {
		 
		Poll poll = new Poll();
		poll.setPollQuestion(pollDto.getPollQuestion());
		poll.setOptions(pollDto.getOptions());
		poll.setTimeStamp(pollDto.getTimeStamp());
		poll.setEndDate(pollDto.getEndDate());
 
		poll.setStatus(pollDto.isStatus());
		
		poll.setVisibility("Open");
		
		region = rgRepo.findById(pollDto.getRegion()).get();
		poll.setRegion(region);
		
		department = dtRepo.findById(pollDto.getDepartment()).get();
		poll.setDepartment(department);
		
		project = ptRepo.findById(pollDto.getProject()).get();
		poll.setProject(project);
		
		user = userRepo.findById(pollDto.getUser()).get();
		poll.setUser(user);
		
		pollRepo.save(poll);
		return true;
	}
	
	public boolean deletePoll(long pollId) {
		pollRepo.deleteById(pollId);
		return true;
	}

	public List<Poll> getAllPollDetails() {
		Iterator<Poll> it = pollRepo.findAll().iterator();
		ArrayList<Poll> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<Poll> pollDetails(long pollId) {
		Iterator<Poll> it = pollRepo.findByPollId(pollId).iterator();
		ArrayList<Poll> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
//	public List<Poll> getPublishedPoll() {
//	    Iterable<Poll> allPoll = pollRepo.findAll();
//	    return StreamSupport.stream(allPoll.spliterator(), true) // Create stream from Iterable
//	        .filter(poll -> poll.isStatus())
//	        .sorted(Comparator.comparing(Poll::getPollId).reversed())
//	        .collect(Collectors.toList());
//	}
	
//	public List<Poll> getPublishedPoll() {
//	    List<Poll> allPoll = pollRepo.findAll();
//	    return allPoll.stream()
//	    		.filter(Poll::isStatus) // Filter for published posts
//                .sorted(Comparator.comparing(Poll::getPollId).reversed()) // Sort by dateTime in reverse order
//                .collect(Collectors.toList());
//	  }
	public List<Poll> getPublishedPoll(){
		List<Poll> allPoll = pollRepo.findAll();
		return allPoll.stream()
				.filter(Poll::isStatus)
				.sorted(Comparator.comparing(Poll::getPollId).reversed())
				.collect(Collectors.toList());
	}
	
	public List<Poll> getDraftPoll() {
	    List<Poll> allPoll = pollRepo.findAll();
	    return allPoll.stream()
	                   .filter(poll -> !poll.isStatus()) // Filter by negation
	                   .sorted(Comparator.comparing(Poll::getPollId).reversed())
	                   .collect(Collectors.toList());
	  }
	 
//	public List<Poll> getDraftPoll() {
//	    Iterable<Poll> allPoll = pollRepo.findAll();
//	    return StreamSupport.stream(allPoll.spliterator(), false) // Create stream from Iterable
//	        .filter(poll -> !poll.isStatus())
//	        .sorted(Comparator.comparing(Poll::getPollId).reversed())
//	        .collect(Collectors.toList());
//	}
	
	public boolean compareDate() {
		Iterator<Poll> it=pollRepo.findAll().iterator();
		while(it.hasNext()) {
		Poll pr=it.next();
		LocalDate today=LocalDate.now();
		String date=pr.getEndDate().toString();
		LocalDate givenDate=LocalDate.parse(date);
		 System.out.println(pr.getEndDate());
		if(today.isAfter(givenDate)) {
			pr.setPollId(pr.getPollId());
			pr.setVisibility("Closed");
		}
		pollRepo.save(pr);
		}
		return true;
	}
	
	public PollDTO getPollDetails(long pollId) {
		 
		Poll poll = pollRepo.findById(pollId).get();
 
		List<Option> list = poll.getOptions();
 
//		System.out.println("Output:" + list.get(0).getValue() + "OptionId:" + list.get(0).getOptionId() + "PollId:"
//				+ list.get(0).getPollId().getPollId());
		PollDTO dto = new PollDTO();
 
		dto.setPollId(poll.getPollId());
		dto.setPollQuestion(poll.getPollQuestion());
		dto.setOptions(poll.getOptions());
 
		return dto;
	}
	
	public List<OptionDTO> getPollOptions(long pollId) {
		 
		Iterator<Option> itOp = optionRepo.findByPollId(pollId).iterator();
		List<OptionDTO> opList = new ArrayList<OptionDTO>();
		while (itOp.hasNext()) {
			Option option = itOp.next();
			OptionDTO optDto = new OptionDTO();
			optDto.setOptionId(option.getOptionId());
			Poll poll = option.getPollId();
			optDto.setPollId(poll.getPollId());
			optDto.setValue(option.getValue());
			opList.add(optDto);
		}
 
		return opList;
	}
}
