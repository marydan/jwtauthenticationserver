package com.stackroute.myauthenticate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Register {

	@Id
	String username;
	
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
