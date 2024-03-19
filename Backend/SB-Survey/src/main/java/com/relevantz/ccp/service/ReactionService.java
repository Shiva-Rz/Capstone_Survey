package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Reaction;
import com.relevantz.ccp.repository.ReactionRepo;

@Service
public class ReactionService {

	@Autowired
	ReactionRepo rnRepo;

	public boolean insert(Reaction reaction) {
		rnRepo.save(reaction);
		return true;
	}

	public boolean update(Reaction reaction) {
		rnRepo.save(reaction);
		return true;
	}

	public boolean delete(long reactionId) {
		rnRepo.deleteById(reactionId);
		return true;
	}

	public List<Reaction> getAllReactionDetails() {
		Iterator<Reaction> it = rnRepo.findAll().iterator();
		ArrayList<Reaction> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<Reaction> DepartmentDetails() {
		Iterator<Reaction> it = rnRepo.getReaction().iterator();
		ArrayList<Reaction> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

}
