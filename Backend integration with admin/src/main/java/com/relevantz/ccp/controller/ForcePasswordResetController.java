package com.relevantz.ccp.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.relevantz.ccp.model.Response;
import com.relevantz.ccp.service.ForcePasswordResetService;
import com.relevantz.ccp.service.PasswordManagerService;

import jakarta.mail.MessagingException;

//import jakarta.mail.MessagingException;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ForcePasswordResetController {
	
	
	@Autowired
	private ForcePasswordResetService service;
	
	@Autowired
    private ForcePasswordResetService resetService;
    
    @Autowired
    private PasswordManagerService passwordManagerService;

	
	@GetMapping("/ForcePassGenerate/{email}")
	public void  forcePassGenerate(@PathVariable("email") String email) throws MessagingException{
		service.generatePassword(email);
    }
	
	@PostMapping("/insertPassword")
    public ResponseEntity<Response> performPasswordInsert(@RequestBody Map<String, String> requestParams) {
        String email = requestParams.get("email");
        String oldPassword = requestParams.get("oldPassword");
        String newPassword = requestParams.get("newPassword");
        String confirmPassword = requestParams.get("confirmPassword");
 
        if (email == null || oldPassword == null || newPassword == null || confirmPassword == null) {
            Response res = new Response("All fields are required.");
            return ResponseEntity.badRequest().body(res);
        }
        String cred = resetService.insertPassword(email, oldPassword, newPassword, confirmPassword);
        if (cred.equals("Record inserted")) {
            Response res = new Response("Password updated successfully.");
            return ResponseEntity.ok(res);
        } else if (cred.equals("New password doesn't match the confirm Password")){
            Response res = new Response("New password doesn't match the confirm Password");
            return ResponseEntity.ok(res);
        }else if (cred.equals("Invalid old password")){
            Response res = new Response("Invalid old password");
            return ResponseEntity.ok(res);
        }else if (cred.equals("Invalid Email")){
            Response res = new Response("Invalid Email");
            return ResponseEntity.ok(res);
        }else if (cred.equals("Password already used")){
            Response res = new Response("Password already used");
            return ResponseEntity.ok(res);
        }
        else {
        	Response res = new Response(cred);
            return ResponseEntity.ok(res);
        }
    }
}
