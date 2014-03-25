package com.caribresort.actions;

import java.io.Serializable;

public class Request implements Serializable{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String action;
	private Serializable object;
	
	public Request() {
		super();
	}

	public Request(String username, String password, String action,
			Serializable object) {
		super();
		this.username = username;
		this.password = password;
		this.action = action;
		this.object = object;
	}

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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Serializable object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "Request [username=" + username + ", password=" + password
				+ ", action=" + action + ", object=" + object + "]";
	}
}
