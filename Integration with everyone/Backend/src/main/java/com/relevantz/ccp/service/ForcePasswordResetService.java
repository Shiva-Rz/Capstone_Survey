package com.relevantz.ccp.service;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.LoginDTO;
import com.relevantz.ccp.model.Login;
import com.relevantz.ccp.model.PasswordManager;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.LoginRepo;
import com.relevantz.ccp.repository.UserRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ForcePasswordResetService {

	 @Autowired
	 private JavaMailSender mailSender;
	 
	 @Autowired
	 private UserRepo userRepo;
	 
	 @Autowired
		private LoginRepo loginRepo;
	 
	@Autowired
	PasswordManagerService passwordManagerService;
	 
	 @Autowired
	 private  LoginService loginservice;
	 
	 @Autowired
	 private LoginDTO logindto;
	 
	 @Autowired
	 private PasswordManager passwordManager ;
	 
	 private Long userId;
	 
	 private String userPassword;
	 
	 private LocalDateTime creationTime = LocalDateTime.now();
	private LocalDateTime expieryTime = creationTime.plusMonths(3);
	 
	 public String generatePassword(String email) throws MessagingException {
		 User user = userRepo.findByUserEmailId(email);
		 userId = user.getUserId();
		 userPassword = "Password@"+(Long.toString(userId));
		 insertLogin(email, userPassword, userId);
		 sendpasswordToMail(email,userPassword);
		 return "Success";
	 }
	 
	 public void insertLogin(String email,String password,Long userId) {
		 logindto =  new LoginDTO();
		 logindto.setUserType("employee");
		 logindto.setUserEmailId(email);
		 logindto.setUser(userId);
		 User user = userRepo.findByUserEmailId(email);
		 logindto.setPassword(password);
		 loginservice.saveOrUpdateLogin(logindto,user);
		
	 }
	 
	 Long lId;
	 public String insertPassword(String email, String oldPassword, String newPassword, String confirmPassword) {
			Login login = loginRepo.findByUserEmailId(email);
			if (login != null) {
				lId = login.getLoginId();
				if (login.getPassword().equals(oldPassword)) {
					if (newPassword.equals(confirmPassword)) {
						if(newPassword.equals(oldPassword)) {
							return "Password already used";
							
						}else {
							login.setPassword(newPassword);
							loginRepo.save(login);
							passwordManager.setCreationDate(creationTime);
							passwordManager.setExpirationDate(expieryTime);
							passwordManager.setLastPassword3(passwordManager.getLastPassword2());
							passwordManager.setLastPassword2(passwordManager.getLastPassword1());
							passwordManager.setLastPassword1(newPassword);
							passwordManager.setLoginId(login);
							passwordManagerService.saveOrUpdatePasswordManager(passwordManager);
							return "Record inserted";
						}
						
					} else {
						return "New password doesn't match the confirm Password";
					}
				} else {
					return "Invalid old password";
				}
			} else {
				return "Invalid Email";
			}
		}
	 
	 private void sendpasswordToMail(String email, String password) throws MessagingException {
	        MimeMessage mimeMessage = mailSender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
	        mimeMessageHelper.setTo(email);
	        mimeMessageHelper.setSubject("CCP Login Credentials");
	        mimeMessageHelper.setText("Here is your Login credentials \n Email"+email+"\n"+"password :"+password);
	        mailSender.send(mimeMessage);
	    }
	 
	 public void sendpasswordService(String email,String password) throws MessagingException {
	        
	        	sendpasswordToMail(email, password);
	        
	    }

}
