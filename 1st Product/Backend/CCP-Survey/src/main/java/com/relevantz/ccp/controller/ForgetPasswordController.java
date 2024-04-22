
package com.relevantz.ccp.controller;
 
import java.time.LocalDateTime;

import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.relevantz.ccp.model.Login;
import com.relevantz.ccp.model.PasswordManager;
import com.relevantz.ccp.model.Response;
import com.relevantz.ccp.service.ForgetPasswordService;

 
@RestController
@CrossOrigin("http://localhost:4200/")
 
public class ForgetPasswordController {
 
	@Autowired
	private ForgetPasswordService service;
 
	// forgetPassword
 
	// This method is used to check the email is valid and send otp
	
	private LocalDateTime creationTimePassword = LocalDateTime.now();
	private LocalDateTime expieryTimePassword = creationTimePassword.plusMonths(3);
 
	@GetMapping("/forgetPassword/{email}")
	public ResponseEntity<Response> checkMailSendOTP(@PathVariable("email") String email) {
 
		if (service.findUser(email)) {
			service.sendOtpService(email);
			Response response = new Response("valid email");
			return ResponseEntity.ok(response);
 
		} else {
			Response response = new Response("Invalid email");
			return ResponseEntity.ok(response);
		}
 
	}
 
	// this method is used to verify the OTP
 
	@PostMapping("/ForgetVerifyOTP")
	public ResponseEntity<Response> verifyOTP(@RequestBody Map<String, String> requestParams) {
 
		String email = requestParams.get("email");
		String otp = requestParams.get("otp");
 
		System.out.println(email+otp);
		if (email == null || otp == null) {
 
			Response res = new Response("Both email and OTP are required.");
			return ResponseEntity.ok(res);
		}
 
		if (service.verifyOTP(email, otp)) {
 
			Response res = new Response("Valid OTP");
			return ResponseEntity.ok(res);
		} else {
			Response res = new Response("Invalid OTP.");
 
			return ResponseEntity.ok(res);
		}
	}
 
	// this method is used to update password
 
	@PostMapping("/updateForgetPassword")
	public ResponseEntity<Response> updatePassword(@RequestBody Map<String, String> requestParams) {
 
		String email = requestParams.get("email");
		String confirmPassword = requestParams.get("confirmPassword");
		String newPassword = requestParams.get("newPassword");
		
		System.out.println(email+confirmPassword+newPassword);
 
		long loginId = service.findLoginId(email);
 
		if (email == null || confirmPassword == null || newPassword == null) {
			Response response = new Response("Enter all details");
 
    	 return ResponseEntity.badRequest().body(response);
		}
 
		if (!confirmPassword.equals(newPassword)){
			Response response = new Response("Confirm Password and new Password must be same");
    		return ResponseEntity.ok(response);
 
		}
		
		
		else {
			PasswordManager passwordDetails = service.findPasswordDetail(loginId);
 
			if (newPassword.equals (passwordDetails.getLastPassword1()) || newPassword.equals (passwordDetails.getLastPassword2())
					|| newPassword.equals(passwordDetails.getLastPassword3()) ){
 
				Response response = new Response("new Password must be new one");
				return ResponseEntity.ok(response);
			}
 
			else {
			
				
				Login login=service.findUserDetail(email);
				login.setPassword(newPassword);
				
				PasswordManager passwordDetail = service.findPasswordDetail(loginId);
				passwordDetail.setCreationDate(creationTimePassword);
				passwordDetail.setExpirationDate(expieryTimePassword);
				passwordDetail.setLastPassword3(passwordDetail.getLastPassword2());
				passwordDetail.setLastPassword2(passwordDetail.getLastPassword1());
				passwordDetail.setLastPassword1(newPassword);
				service.saveOrUpdateLogin(login);
				service.saveOrUpdatePasswordManager(passwordDetail);
				
				Response response = new Response("New Password set successfully");
				return ResponseEntity.ok(response);
				
				
				
 
			}
 
		}
		
		
 
	}
 
}
 