package com.relevantz.ccp.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.relevantz.ccp.model.Response;
import com.relevantz.ccp.service.EmailSendService;

@RestController
@CrossOrigin("http://localhost:4200/")

public class EmailSendController {

    @Autowired
    private EmailSendService sendService;

    @GetMapping("/resendOTP/{email}")
    public void  sendOtpToMail(@PathVariable("email") String email) {
        sendService.sendOtpService(email);
    }


    
    @PostMapping("/verifyOTP")
    public ResponseEntity<Response> verifyOTP(@RequestBody Map<String, String> requestParams) {
        String email = requestParams.get("email");
        String otp = requestParams.get("otp");
        
        if (email == null || otp == null) {
        	
        	Response res=new Response("Both email and OTP are required.");
            return ResponseEntity.ok(res);
        }
 
        if (sendService.verifyOTP(email, otp)) {
        	
        	Response res=new Response("Valid OTP");
            return ResponseEntity.ok(res);
        }
     
        else {
        	Response res=new Response("Invalid OTP");
        	return ResponseEntity.ok(res);
        }
    }
}