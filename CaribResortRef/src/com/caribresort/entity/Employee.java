package com.caribresort.entity;
// Generated Feb 25, 2014 2:21:24 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Employee generated by hbm2java
 */
public class Employee  implements CaribResortEntity {


     /**
	 * 
	 */
	private static final long serialVersionUID = -3443526601298619431L;
	private Integer employeeId;
     private Role role;
     private String firstName;
     private String lastName;
     private String userName;
     private String password;
     private String email;
     private Date dateOfBirth;
     private Date createdDate;
     private Date lastLoginDate;
     private Set<Customerorder> customerorders = new HashSet<Customerorder>();

    public Employee() {
    }

    public Employee(Role role, String firstName, String lastName, String userName, String password, String email, Date dateOfBirth, Date createdDate, Date lastLoginDate, Set<Customerorder> customerorders) {
       this.role = role;
       this.firstName = firstName;
       this.lastName = lastName;
       this.userName = userName;
       this.password = password;
       this.email = email;
       this.dateOfBirth = dateOfBirth;
       this.createdDate = createdDate;
       this.lastLoginDate = lastLoginDate;
       this.customerorders = customerorders;
    }
   
    public Integer getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getLastLoginDate() {
        return this.lastLoginDate;
    }
    
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    public Set<Customerorder> getCustomerorders() {
        return this.customerorders;
    }
    
    public void setCustomerorders(Set<Customerorder> customerorders) {
        this.customerorders = customerorders;
    }

	@Override
	public Object PopulateFromArray(Object[] data) {
		// TODO Auto-generated method stub
		return null;
	}




}

