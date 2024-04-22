package com.relevantz.ccp.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_invitation")
@Component
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invitation_id")
    private Long invitationId;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column(name = "recipient_email")
    private String recipientEmail;

    @Column(name = "invitation_code")
    private String invitationCode;

    @Column(name = "sent_time")
    private LocalDateTime sentTime;

    @Column(name = "accepted")
    private boolean accepted;

    @Column(name = "accepted_time")
    private LocalDateTime acceptedTime;

	public Invitation() {
		super();
	}

	public Invitation(Long invitationId, User sender, String recipientEmail, String invitationCode, LocalDateTime sentTime,
			boolean accepted, LocalDateTime acceptedTime) {
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

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
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

	public LocalDateTime getSentTime() {
		return sentTime;
	}

	public void setSentTime(LocalDateTime sentTime) {
		this.sentTime = sentTime;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public LocalDateTime getAcceptedTime() {
		return acceptedTime;
	}

	public void setAcceptedTime(LocalDateTime acceptedTime) {
		this.acceptedTime = acceptedTime;
	}

}