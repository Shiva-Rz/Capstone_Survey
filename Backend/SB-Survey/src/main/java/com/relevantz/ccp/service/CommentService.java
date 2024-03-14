package com.relevantz.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Comment;
import com.relevantz.ccp.repository.CommentRepo;

@Service
public class CommentService {

	@Autowired
	CommentRepo crRepo;

	public boolean insert(Comment comment) {
		crRepo.save(comment);
		return true;
	}

	public boolean update(Comment comment) {
		crRepo.save(comment);
		return true;
	}

	public boolean delete(long commentId) {
		crRepo.deleteById(commentId);
		return true;
	}

	public List<Comment> getAllCommentDetails() {
		Iterator<Comment> it = crRepo.findAll().iterator();
		ArrayList<Comment> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

}
