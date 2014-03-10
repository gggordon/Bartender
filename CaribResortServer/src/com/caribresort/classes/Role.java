package com.caribresort.classes;

public class Role {

	private int roleId;
	private String roleName;
	
	public void setManger(){
		//TODO : Run Database query to get id for manager role
		setRole(1,"manager");
	}
	
    public void setBartender(){
    	//TODO : Run Database query to get id for bartender role
    	setRole(2,"bartender");
	}

    public void setUser(){
	    //TODO : Run Database query to get id for user role
    	setRole(2,"user");
    }
    
    public Role(){
    	setUser();
    }
	
	private void setRole(int roleId,String roleName){
		this.roleId=roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	@Override
	public String toString() {
		return "{roleId:" + roleId + ", roleName:" + roleName + "}";
	}
	
	
}
