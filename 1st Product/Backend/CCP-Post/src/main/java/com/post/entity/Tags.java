package com.post.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_tags")
@Component
public class Tags {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagId;
    @ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;
    
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name="user_first_name")
//    private User userName;
	
	public Tags() {
		super();
		
	}

	public Tags(long tagId, User user) {
		super();
		this.tagId = tagId;
		this.user = user;
	}

	public long getTagId() {
		return tagId;
	}

	public void setTagId(long tagId) {
		this.tagId = tagId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
