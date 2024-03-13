package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Pages;
import com.relevantz.ccp.repository.PagesRepo;

@Service
public class PagesService {

	@Autowired
	PagesRepo pgRepo;
	
	public boolean insert(Pages pages) {
		pgRepo.save(pages);
		return true;
   }
	
	public boolean update(Pages pages) {
		pgRepo.save(pages);
		return true;
	}
	
	public boolean delete(long pageId) {
		pgRepo.deleteById(pageId);
		return true;
	}
	
	public List<Pages> getAllPagesDetails(){
		Iterator<Pages> it=pgRepo.findAll().iterator();
		ArrayList<Pages> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

}
