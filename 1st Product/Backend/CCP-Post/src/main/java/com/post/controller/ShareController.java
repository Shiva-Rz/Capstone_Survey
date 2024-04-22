package com.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.entity.Share;
import com.post.service.ShareService;
@RestController
@CrossOrigin("http://localhost:4200/") 
public class ShareController {

	@Autowired(required = true)
	ShareService shareservice;

	@PostMapping("/Share")
	public boolean shareInsert(@RequestBody Share share) {
		shareservice.addShare(share);
		return true;
	}

	@PutMapping("/Share")
	public boolean shareUpdate(@RequestBody Share share) {
		shareservice.updateShare(share);
		return true;
	}

	@DeleteMapping("/Share/{shareId}")
	public void performDelete(@RequestBody long shareId) {
		shareservice.deleteShare(shareId);

	}

	@GetMapping("/Share")
	public List<Share> viewAllSharedDetails() {
		return shareservice.getAllSharedDetails();

	}

}
