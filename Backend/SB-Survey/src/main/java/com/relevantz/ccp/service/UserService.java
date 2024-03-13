package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo urRepo;
	
	public boolean insert(User user) {
		urRepo.save(user);
		return true;
   }
	
	public boolean update(User user) {
		urRepo.save(user);
		return true;
	}
	
	public boolean delete(long userId) {
		urRepo.deleteById(userId);
		return true;
	}
	
	public List<User> getAllUserDetails(){
		Iterator<User> it=urRepo.findAll().iterator();
		ArrayList<User> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public List<User> getDetails(){
		Iterator<User> it=urRepo.getUserData().iterator();
		ArrayList<User> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
}
