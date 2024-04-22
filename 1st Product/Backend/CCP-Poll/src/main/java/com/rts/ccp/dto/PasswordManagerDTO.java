package com.rts.ccp.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class PasswordManagerDTO {
    private Long passwordId;
    
    private Long user;
    
    private Timestamp creationDate;
    private Timestamp expirationDate;
    private String lastPassword1;
    private String lastPassword2;
    private String lastPassword3;
	public PasswordManagerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PasswordManagerDTO(Long passwordId, Long user, Timestamp creationDate, Timestamp expirationDate,
			String lastPassword1, String lastPassword2, String lastPassword3) {
		super();
		this.passwordId = passwordId;
		this.user = user;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
		this.lastPassword1 = lastPassword1;
		this.lastPassword2 = lastPassword2;
		this.lastPassword3 = lastPassword3;
	}
	public Long getPasswordId() {
		return passwordId;
	}
	public void setPasswordId(Long passwordId) {
		this.passwordId = passwordId;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getLastPassword1() {
		return lastPassword1;
	}
	public void setLastPassword1(String lastPassword1) {
		this.lastPassword1 = lastPassword1;
	}
	public String getLastPassword2() {
		return lastPassword2;
	}
	public void setLastPassword2(String lastPassword2) {
		this.lastPassword2 = lastPassword2;
	}
	public String getLastPassword3() {
		return lastPassword3;
	}
	public void setLastPassword3(String lastPassword3) {
		this.lastPassword3 = lastPassword3;
	}

    
}
