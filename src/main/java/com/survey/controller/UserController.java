package com.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.survey.bean.User;
import com.survey.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	 UserService urService;
	
	@PostMapping("/user")
	public String performInsert(@RequestBody User user) {
		urService.insert(user);
	    return "Record Inserted";
	    
	}
	
	@PutMapping("/user")
	public String performUpdate(@RequestBody User user) {
		urService.update(user);	
		return "Record Updated";
	}
	
	@DeleteMapping("/user/{userId}")
	public void performDelete(@PathVariable("userId") long userId) {
		urService.delete(userId);
	}
	
	@GetMapping("/user")
	public List<User> viewAllUserDetails(){
		return urService.getAllUserDetails();
	}
	
	@GetMapping("/userdetail")
	public List<User> viewUserDetails(){
		return urService.getDetails();
	}

}
