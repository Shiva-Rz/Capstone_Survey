package com.relevantz.ccp.service;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.LoginDTO;
import com.relevantz.ccp.model.Login;
import com.relevantz.ccp.model.PasswordManager;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.LoginRepo;
import com.relevantz.ccp.repository.PasswordManagerRepo;
import com.relevantz.ccp.repository.UserRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
 
@Service
public class LoginService {
	
	@Autowired
	private Login login;
	
	@Autowired
	private User user;
 
    @Autowired
    private LoginRepo loginRepo;
    
    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PasswordManagerRepo passwordManagerRepo;
    
    
    private LocalDateTime currentTime;
	private LocalDateTime expieryTime;
 
    public boolean saveOrUpdateLogin(LoginDTO logindto) {
    	login.setUserEmailId(logindto.getUserEmailId());
    	user.setUserId(logindto.getUser());
    	login.setUser(user);
    	login.setUserType(logindto.getUserType());
    	login.setPassword(logindto.getPassword());
        loginRepo.save(login);
        return true;
    }
 
    public boolean saveOrUpdateLogin(LoginDTO logindto,User newUser) {
    	login.setUserEmailId(logindto.getUserEmailId());
    	login.setUser(newUser);
    	login.setUserType(logindto.getUserType());
    	login.setPassword(logindto.getPassword());
        loginRepo.save(login);
        return true;
    }
    public boolean deleteLoginByEmailId(String emailId) {
        loginRepo.deleteById(emailId);
        return true;
    }
 
    public List<Login> getAllLogins() {
        return loginRepo.findAll();
    }
    
    
    public String verifyLogin(String userEmailId) {
    	Login login = loginRepo.findByUserEmailId(userEmailId);
    	if(login ==null) {
    		return "Failed";
    	}
    	else {
    		return "Success";
    	}
    }
 
    public String verifyLogin(String userEmailId, String password) {
        Login login = loginRepo.findByUserEmailIdAndPassword(userEmailId, password);
        
 
        if (login != null) {
            return login.getUserEmailId(); // Return the email if login is successful
        } else {
            return null;
        }
    }
 
    public String getUserTypeByEmail(String email) {
        return loginRepo.findByUserEmailId(email).getUserType();
    }
    
    public Long getUserIdByEmail(String email) {
        return loginRepo.findByUserEmailId(email).getUser().getUserId();
    }
 
    public void updateFailedLoginAttempts(String userEmailId) {
        Login login = loginRepo.findByUserEmailId(userEmailId);
        login.setLoginAttempts(login.getLoginAttempts() + 1);
        login.setLastFailedAttempt(LocalDateTime.now());
        loginRepo.save(login);
    }
 
    public int getLoginAttempts(String userEmailId) {
    	Login login = loginRepo.findByUserEmailId(userEmailId);
    	return login.getLoginAttempts();
    	
    }
    public boolean isLoginDisabled(String userEmailId) {
        Login login = loginRepo.findByUserEmailId(userEmailId);
        if (login.getLoginAttempts() >= 5) {
            LocalDateTime lastAttempt = login.getLastFailedAttempt();
            LocalDateTime now = LocalDateTime.now();
            return lastAttempt != null && lastAttempt.isAfter(now.minusMinutes(5));
        }
        return false;
    }
 
    public void resetLoginAttempts(String userEmailId) {
        Login login = loginRepo.findByUserEmailId(userEmailId);
        login.setLoginAttempts(0);
        loginRepo.save(login);
    }
   //modified code
    public Login verifyEmail( String userEmailId)
    {
    	Login login = loginRepo.findByUserEmailId(userEmailId);
    	return login;
    }
    
    //Check for force password reset
    
    public boolean verifyNewUser(String userEmailId) {
    	Login login = verifyEmail(userEmailId);
    	Long loginId = login.getLoginId();
    	PasswordManager passwordManager = passwordManagerRepo.findUser(loginId);
    	if(passwordManager ==null) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public String verifyTimeExpiery(String userEmailId) {
    	Login login = verifyEmail(userEmailId);
    	Long loginId = login.getLoginId();
    	PasswordManager passwordManager = passwordManagerRepo.findUser(loginId);
    	currentTime = LocalDateTime.now();
    	expieryTime = passwordManager.getExpirationDate();
		LocalDateTime temp = expieryTime.minusDays(10);
		if (currentTime.isAfter(temp)){
			for(int i=0;i<10;i++) {
				if(currentTime.plusDays(i).isAfter(expieryTime)) {
					if(i==0) {
						return "fail";
					}
					return Integer.toString(i);
				}
			}
		}
		return "pass";
    }
    
    public Long getRegionIdByEmail(String email) {
    	User newUser = userRepo.findByUserEmailId(email);
    	return newUser.getRegion().getRegionId();
    }
    public Long getDepartmentIdByEmail(String email) {
    	User newUser = userRepo.findByUserEmailId(email);
    	return newUser.getDepartment().getDepartmentId();
    }
     
}