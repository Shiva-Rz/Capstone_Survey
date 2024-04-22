package com.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSendService {
	
	private LocalDateTime creation_time;
	private LocalDateTime expiery_time;

    @Autowired
    private JavaMailSender mailSender;

    private final Map<String, String> otpStorage = new HashMap<>();

    public void sendOtpService(String email) {
        String otp = generateOtp();
        try {
            sendOtpToMail(email, otp);
            otpStorage.put(email, otp); // Store OTP in the map
        } catch (MessagingException e) {
            throw new RuntimeException("Unable to send OTP");
        }
    }

    private void sendOtpToMail(String email, String otp) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Email Verification OTP");
        mimeMessageHelper.setText("Your CCP Application Login OTP is: " + otp); // Set the OTP in the email body
        mailSender.send(mimeMessage);
    }

//    private String generateOtp() {
//        SecureRandom random = new SecureRandom();
//        int otp = 100000 + random.nextInt(900000);
//        return String.valueOf(otp);
//    }
//
//    public boolean verifyOTP(String email, String otp) {
//        String storedOtp = otpStorage.get(email);
//        if (storedOtp != null && storedOtp.equals(otp)) {
//            otpStorage.remove(email); // Remove OTP from storage after verification
//            return true;
//        }
//        return false;
//    }
    
    private String generateOtp() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        creation_time = LocalDateTime.now();
        System.out.println(creation_time);
        return String.valueOf(otp);
    }
 
//    public boolean verifyOTP(String email, String otp) {
//        String storedOtp = otpStorage.get(email);
//        expiery_time = LocalDateTime.now();
//        if(creation_time.isAfter(expiery_time.minusMinutes(1))) {
//        	if (storedOtp != null && storedOtp.equals(otp)) {
//                otpStorage.remove(email);
//                System.out.println(LocalDateTime.now());
//                return true;
//            }
//        }
//        System.out.println(LocalDateTime.now());
//        otpStorage.remove(email);
//        return false;
//    }
    
    public boolean verifyOTP(String email, String otp) {
        String storedOtp = otpStorage.get(email);
        expiery_time = LocalDateTime.now();
        if(creation_time.isAfter(expiery_time.minusMinutes(1))) {
        	if (storedOtp != null && storedOtp.equals(otp)) {
                otpStorage.remove(email);
                return true;
            }else {
        		return false;
        	}
        }
        else {
	        otpStorage.remove(email);
	        return false;
        }
    }
}