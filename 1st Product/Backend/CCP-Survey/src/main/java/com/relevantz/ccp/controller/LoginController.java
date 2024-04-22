package com.relevantz.ccp.controller;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.relevantz.ccp.dto.LoginDTO;
import com.relevantz.ccp.model.Login;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.UserRepo;
import com.relevantz.ccp.service.EmailSendService;
import com.relevantz.ccp.service.LoginService;
import com.relevantz.ccp.service.UserService;
import com.relevantz.ccp.util.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
@RestController
@CrossOrigin("http://localhost:4200/")
public class LoginController {
 
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private UserRepo userRepo;
 
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private EmailSendService sendService;
    
    @Autowired
    private UserService userService;
    
    
    @PostMapping("/insertLogin")
    public void performInsert(@RequestBody LoginDTO logindto) {
    	loginService.saveOrUpdateLogin(logindto);
    }

 
    @DeleteMapping("/Logins/{emailId}")
    public void performDelete(@PathVariable String emailId) {
        loginService.deleteLoginByEmailId(emailId);
    }
 
    @GetMapping("/Logins")
    public List<Login> viewAllLogins() {
        return loginService.getAllLogins();
    }
 
        
    //new method
    
    @PostMapping("/login")
	public ResponseEntity<Map<String, String>> verifyLogin(@RequestBody Login loginRequest) {
		if (loginService.verifyLogin(loginRequest.getUserEmailId()).equals("Failed")) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Email not found. Please Contact Admin");
			return ResponseEntity.badRequest().body(response);
		} else {
			if (loginService.isLoginDisabled(loginRequest.getUserEmailId())) {
				Map<String, String> response = new HashMap<>();
				response.put("message", "Login disabled. Try again after 5 minutes.");
				return ResponseEntity.badRequest().body(response);
			}
 
			String email = loginService.verifyLogin(loginRequest.getUserEmailId(), loginRequest.getPassword());
 
			if (email != null) {
				Map<String, String> response = new HashMap<>();
				loginService.resetLoginAttempts(loginRequest.getUserEmailId());
				if(loginService.verifyNewUser(email)) {
					response.put("email", email);
					response.put("message", "newUser");
					return ResponseEntity.ok(response);
				}
				String userType = loginService.getUserTypeByEmail(email);
				User user = userRepo.findByUserEmailId(email);
				String token = jwtUtil.generateToken(user);
				Long userId = loginService.getUserIdByEmail(email);
				
				List<Long> list=userService.findUserProjectById(userId);
				response.put("token", token);
				response.put("userType", userType);
				response.put("email", email);
				response.put("userId", Long.toString(userId));
				response.put("ForcePass", loginService.verifyTimeExpiery(email));
			
				response.put("projectId", list.toString());
				System.out.println(list.toString());
				response.put("regionId",loginService.getRegionIdByEmail(email).toString());
				response.put("departmentId", loginService.getDepartmentIdByEmail(email).toString());
				sendService.sendOtpService(email);
				return ResponseEntity.ok(response);

			} else {
 
				loginService.updateFailedLoginAttempts(loginRequest.getUserEmailId());
				Map<String, String> response = new HashMap<>();
 
				int attempts = loginService.getLoginAttempts(loginRequest.getUserEmailId());
 
				if (attempts < 3) {
					response.put("message", "Login failed. Invalid credentials.");
				} else if (attempts == 3) {
					response.put("message", "Login failed. 2 attempts remaining.");
				} else if (attempts == 4) {
					response.put("message", "Login failed. 1 attempts remaining.");
				} else if (attempts == 5) {
					response.put("message", "Login failed. 1 attempts remaining.");
				}
				return ResponseEntity.badRequest().body(response);
 
			}
		}
	}
        
//    @GetMapping("/")
//    public String welcome() {
//        return "Welcome to javatechie !!";
//    }   
       
    }