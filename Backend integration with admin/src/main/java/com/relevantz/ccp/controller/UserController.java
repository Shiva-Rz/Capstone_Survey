package com.relevantz.ccp.controller;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.relevantz.ccp.dto.UserDTO;
import com.relevantz.ccp.service.UserService;

import java.util.List;
import java.util.Map;
 
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
    
    @GetMapping("/findProject/{userId}")
    public List<String> finduserProject(@PathVariable Long userId) {
         return userService.findUseProject(userId);
    }
 

}