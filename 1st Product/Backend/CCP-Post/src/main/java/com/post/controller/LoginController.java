package com.post.controller;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.entity.Login;
import com.post.entity.LoginDTO;
import com.post.service.EmailSendService;
import com.post.service.LoginService;
import com.post.service.UserService;
import com.post.util.JwtUtil;
 
@RestController
@CrossOrigin("http://localhost:4200/")
public class LoginController {
 
    @Autowired
    private LoginService loginService;
 
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
			response.put("message", "Email not found");
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
				String token = jwtUtil.generateToken(email, userType);
				Long userId = loginService.getUserIdByEmail(email);
				List<Long> list=userService.findUserProject(userId);
				
				response.put("token", token);
				response.put("userType", userType);
				response.put("email", email);
				response.put("userId", Long.toString(userId));
				response.put("ForcePass", loginService.verifyTimeExpiery(email));
				
				
				
				if(loginService.getRegionIdByEmail(email)==null )
				{
					response.put("regionId", "Not Assigned");
				}
				else
				{
					response.put("regionId",loginService.getRegionIdByEmail(email).toString());
				}
				
//				response.put("regionId",loginService.getRegionIdByEmail(email).toString());
				
				if(loginService.getDepartmentIdByEmail(email)==null)
				{
					response.put("departmentId","Not Assigned");
				}
				else
				{
					response.put("departmentId", loginService.getDepartmentIdByEmail(email).toString());
				}
				
				if(list.isEmpty()) {
					response.put("projectId","Not Assigned");
				}
				else
				{
					response.put("projectId", list.toString());
				}
				
				
				 System.out.println(loginService.getDepartmentIdByEmail(email).toString());  
				System.out.println(loginService.getRegionIdByEmail(email).toString());
				sendService.sendOtpService(email);
				System.out.println(list.toString());
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