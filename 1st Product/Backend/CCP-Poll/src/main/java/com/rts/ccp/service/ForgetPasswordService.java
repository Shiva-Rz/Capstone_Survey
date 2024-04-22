
package com.rts.ccp.service;
 
import java.security.SecureRandom;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rts.ccp.bean.Login;
import com.rts.ccp.bean.PasswordManager;
import com.rts.ccp.repository.LoginRepo;
import com.rts.ccp.repository.PasswordManagerRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
 
@Service
public class ForgetPasswordService {
 
	private LocalDateTime creationTime;
	private LocalDateTime expieryTime;
	
 
	@Autowired
	JavaMailSender mailSender;
 
	@Autowired
 
	LoginRepo loginDAO;
 
	@Autowired
	PasswordManagerRepo passManagerDAO;
 
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
		mimeMessageHelper.setText("Your CCP Application Forget Password OTP is: " + otp); // Set the OTP in the email
																							// body
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
		if (creationTime.isAfter(expieryTime.minusMinutes(1))) {
			if (storedOtp != null && storedOtp.equals(otp)) {
				otpStorage.remove(email);
				System.out.println(LocalDateTime.now());
				return true;
			}
			else {
				return false;
			}
		}
		
		System.out.println(LocalDateTime.now());
		otpStorage.remove(email);
		return false;
	}
 
	public boolean findUser(String email) {
		Login login = loginDAO.findByUserEmailId(email);
		if (login != null) {
			return true;
		} else {
			return false;
		}
 
	}
 
	// this method is used to find userid from the login table using unique email
	
	public long findLoginId(String email) {
		Login login = loginDAO.findByUserEmailId(email);
		return login.getLoginId();
	}
 
	public PasswordManager findPasswordDetail(long loginId) {
		
		return passManagerDAO.findById(loginId).get();
		
 
	}
	
	
	public Login findUserDetail(String email) {
		Login login = loginDAO.findByUserEmailId(email);
		return login;
	}
	
	
	 public boolean saveOrUpdatePasswordManager(PasswordManager passwordManager) {
		 passManagerDAO.save(passwordManager);
	        return true;
	    }
	
	  public boolean saveOrUpdateLogin(Login login) {
		  loginDAO.save(login);
	        return true;
	    }
 
}
 