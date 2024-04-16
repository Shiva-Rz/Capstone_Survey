package com.relevantz.ccp.dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class LoginDTO {
    private Long loginId;
    private String userEmailId;
    private String password;
    private String userType;
    private int loginAttempts;
    private LocalDateTime lastFailedAttempt;
    private Long user;
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(Long loginId, String userEmailId, String password, String userType, int loginAttempts,
			LocalDateTime lastFailedAttempt, Long user) {
		super();
		this.loginId = loginId;
		this.userEmailId = userEmailId;
		this.password = password;
		this.userType = userType;
		this.loginAttempts = loginAttempts;
		this.lastFailedAttempt = lastFailedAttempt;
		this.user = user;
	}
	public Long getLoginId() {
		return loginId;
	}
	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getLoginAttempts() {
		return loginAttempts;
	}
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	public LocalDateTime getLastFailedAttempt() {
		return lastFailedAttempt;
	}
	public void setLastFailedAttempt(LocalDateTime lastFailedAttempt) {
		this.lastFailedAttempt = lastFailedAttempt;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}

    
}