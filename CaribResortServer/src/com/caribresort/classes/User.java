package com.caribresort.classes;

import java.sql.Date;

public abstract class User extends Person implements Roleable{
	private String username;
	private String password;
	private Role role;
	
	public User(){
		this("","");
	}
	
	public User(String username, String password){
		super();
		this.username=username;
		this.password=password;
		this.setRole(new Role());
	}	
	
	
	
	
	public User(int personId, String firstName, String lastName, String email,
			Date dateOfBirth, Date createdDate, Date lastLoginDate, String username, String password) {
		super(personId, firstName, lastName, email, dateOfBirth, createdDate,
				lastLoginDate);
		this.username=username;
		this.password=password;
		this.setRole(new Role());
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
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "{username:" + username + ", password:" + password + ",role : "+role.toString()+", person : "+super.toString()+"}";
	}
	
	
	
	

}
