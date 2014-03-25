package com.caribresort.classes;

import java.sql.Date;

public abstract class Person {
      private int personId;
      private String firstName;
      private String lastName;
      private String email;
      private Date dateOfBirth;
      private Date createdDate;
      private Date lastLoginDate;
      
      
      public Person(){
    	  this(0,"","","",
    			  new Date(new java.util.Date().getTime()),
    			  new Date(new java.util.Date().getTime()),
    			  new Date(new java.util.Date().getTime()));
      }
      
	public Person(int personId, String firstName, String lastName,
			String email, Date dateOfBirth, Date createdDate,
			Date lastLoginDate) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
		
	}


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	@Override
	public String toString() {
		return "{personId:" + personId + ", firstName:" + firstName
				+ ", lastName:" + lastName + ", email:" + email
				+ ", dateOfBirth:" + dateOfBirth + ", createdDate:"
				+ createdDate + ", lastLoginDate:" + lastLoginDate+"}";
	}
	
	
      
      
      

}
