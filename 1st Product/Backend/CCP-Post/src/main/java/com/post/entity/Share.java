package com.post.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
//@Table(name="tbl_share")
@Component
public class Share {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="share_id")
	private long shareId;
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="date_time")
	private Date dateTime;
	public Share() {
		super();
	}
	public Share(long shareId, User user, Date dateTime) {
		super();
		this.shareId = shareId;
		this.user = user;
		this.dateTime = dateTime;
	}
	public long getShareId() {
		return shareId;
	}
	public void setShareId(long shareId) {
		this.shareId = shareId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
