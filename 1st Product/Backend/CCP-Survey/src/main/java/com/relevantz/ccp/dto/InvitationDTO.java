package com.relevantz.ccp.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class InvitationDTO {
    private Long invitationId;
    private UserDTO sender;
    private String recipientEmail;
    private String invitationCode;
    private Timestamp sentTime;
    private boolean accepted;
    private Timestamp acceptedTime;
	public InvitationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvitationDTO(Long invitationId, UserDTO sender, String recipientEmail, String invitationCode,
			Timestamp sentTime, boolean accepted, Timestamp acceptedTime) {
		super();
		this.invitationId = invitationId;
		this.sender = sender;
		this.recipientEmail = recipientEmail;
		this.invitationCode = invitationCode;
		this.sentTime = sentTime;
		this.accepted = accepted;
		this.acceptedTime = acceptedTime;
	}
	public Long getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
	}
	public UserDTO getSender() {
		return sender;
	}
	public void setSender(UserDTO sender) {
		this.sender = sender;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public Timestamp getSentTime() {
		return sentTime;
	}
	public void setSentTime(Timestamp sentTime) {
		this.sentTime = sentTime;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public Timestamp getAcceptedTime() {
		return acceptedTime;
	}
	public void setAcceptedTime(Timestamp acceptedTime) {
		this.acceptedTime = acceptedTime;
	}

    
}