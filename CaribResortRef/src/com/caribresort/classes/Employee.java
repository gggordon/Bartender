package com.caribresort.classes;

import java.sql.Date;



public class Employee extends User{

	private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private Date createdDate;
    private Date lastLoginDate;
    
	@Override
	public boolean Login(String username, String password) {
		boolean loginSuccess = false;
		// TODO Fully Implement Login Method for Employee
		if(loginSuccess)
			this.getRole().setBartender();
		return loginSuccess;
	}
	
	public boolean Serve(Drink drink){
		return true;
	}

}
