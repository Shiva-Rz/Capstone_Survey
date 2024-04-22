package com.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.entity.UserDTO;
import com.post.service.UserService;
 
@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @PostMapping("/insertUsers")
    public void performInsert(@RequestBody UserDTO user) {
        userService.saveOrUpdateUser(user);
    }
 
    @PutMapping("/updateUsers")
    public void performUpdate(@RequestBody UserDTO user) {
        userService.saveOrUpdateUser(user);
    }
 
    @DeleteMapping("/deleteUsers/{userId}")
    public void performDelete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }
 
//    @GetMapping("/findAllUsers")
//    public List<User> viewAllUsers() {
//        return userService.getAllUsers();
//    }
//    
 
    @GetMapping("/findAllEmployees")
    public List<UserDTO> viewAllEmployees() {
        return userService.getAllEmployees();
    }
    @GetMapping("/MapAllEmployees")
    public List<UserDTO> mapEmployees() {
        return userService.getEmployeesToMap();
    }

    
    @GetMapping("/getEmployeeToGeneratePassword")
    public List<UserDTO> getEmployeeGenerate() {
        return userService.generateEmployeePassword();
    }
    
    //new method
    
    @GetMapping("/findProjectUser/{userId}")
	public List<Long> findProject(@PathVariable  long userId ) {
		return userService.findUserProject(userId);
	}

}