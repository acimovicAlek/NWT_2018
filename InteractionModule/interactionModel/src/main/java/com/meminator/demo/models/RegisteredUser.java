package com.meminator.demo.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RegisteredUser {
	@Id
	long id; 
	
	String username; 
	
	@Temporal(TemporalType.TIMESTAMP)
	Date lastTimeChecked; 
	
	public RegisteredUser()	{
		
	}
	public RegisteredUser(long id)	{
		this.id = id; 
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLastTimeChecked() {
		return lastTimeChecked;
	}

	public void setLastTimeChecked(Date lastTimeChecked) {
		this.lastTimeChecked = lastTimeChecked;
	}
}