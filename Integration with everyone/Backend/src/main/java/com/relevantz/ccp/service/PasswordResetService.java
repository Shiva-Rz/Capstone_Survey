package com.relevantz.ccp.service;
 
import java.security.SecureRandom;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.model.Login;
import com.relevantz.ccp.model.PasswordManager;
import com.relevantz.ccp.repository.LoginRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
 
@Service
public class PasswordResetService {
 
	private LocalDateTime creationTime = LocalDateTime.now();
	private LocalDateTime expieryTime = LocalDateTime.now();;
	
	@Autowired
	private JavaMailSender mailSender;
 
	@Autowired
	private LoginRepo loginRepo;
 
	@Autowired
	PasswordManagerService passwordManagerService;
 
	Long lId;
 
	public String updatePassword(String email, String oldPassword, String newPassword, String confirmPassword) {
		Login login = loginRepo.findByUserEmailId(email);
		if (login != null) {
			lId = login.getLoginId(); // Store login_id
			if (login.getPassword().equals(oldPassword)) {
				if (newPassword.equals(confirmPassword)) {
					// Additional functionality
					PasswordManager passwordManager = passwordManagerService.findByLoginId(lId);
					if (passwordManager != null) {
						if (newPassword.equals(passwordManager.getLastPassword1())
								|| newPassword.equals(passwordManager.getLastPassword2())
								|| newPassword.equals(passwordManager.getLastPassword3())) {
							return "Password already used";
						} else {
							passwordManager.setCreationDate(creationTime);
							passwordManager.setExpirationDate(creationTime.plusMonths(3));
							passwordManager.setLastPassword3(passwordManager.getLastPassword2());
							passwordManager.setLastPassword2(passwordManager.getLastPassword1());
							passwordManager.setLastPassword1(newPassword);
							passwordManagerService.saveOrUpdatePasswordManager(passwordManager);
							login.setPassword(newPassword);			
							loginRepo.save(login);
						}
					}
					return "Record inserted";
				} else {
					return "New password doesn't match the old Password";
				}
			} else {
				return "Invalid old password";
			}
		} else {
			return "Invalid Email";
		}
	}
	
	private final Map<String, String> otpStorage = new HashMap<>();
 
	public void sendOtpService(String email) {
		String otp = generateOtp();
		try {
			sendOtpToMail(email, otp);
			otpStorage.put(email, otp);
		} catch (MessagingException e) {
			throw new RuntimeException("Unable to send OTP");
		}
	}
 
	private void sendOtpToMail(String email, String otp) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setSubject("Email Verification OTP");
		mimeMessageHelper.setText("Your CCP Application Password reset verification OTP is: " + otp);
		mailSender.send(mimeMessage);
	}
 
	private String generateOtp() {
		SecureRandom random = new SecureRandom();
		int otp = 100000 + random.nextInt(900000);
		creationTime = LocalDateTime.now();
		System.out.println(creationTime);
		return String.valueOf(otp);
	}
 
	public boolean verifyOTP(String email, String otp) {
		String storedOtp = otpStorage.get(email);
		expieryTime = LocalDateTime.now();
		if (creationTime.isAfter(expieryTime.minusMinutes(5))) {
			if (storedOtp != null && storedOtp.equals(otp)) {
				otpStorage.remove(email);
				return true;
			}
			else {
				return false;
			}
		}
		otpStorage.remove(email);
		return false;
	}
 
}
 