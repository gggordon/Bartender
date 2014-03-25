package com.caribresort.classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Manager extends User{

	@Override
	public boolean Login(String username, String password) {
		boolean loginSuccess = false;
		// TODO : Fully Implement Login Method for Manager
		//if(loginSuccess)
		//	this.getRole().setManger();
		return loginSuccess;
	}
	//TODO : Implement Manager Functions
	//Manager Functions
	public void GenerateDailyReport(Date day){
		System.out.println("Generating Daily Report for "+day.toString());
		GenerateReport(day,day);
	}
	
	public void GenerateSpecialReport(Date begin, Date end){
		System.out.println("Generating Special Report from "+begin.toString()+" to "+end.toString());
		GenerateReport(begin,end);
	}
	
	private List<Object> GenerateReport(Date begin, Date end){
		if(begin.equals(end)){
			//generating report for one day
			
		}
		return new ArrayList<Object>();
	}
	
	public boolean addDrink(Drink item){
		return true;
	}
	
	public boolean deleteDrink(int id){
		return true;
	}
	
	public boolean updateDrink(Drink item){
		return true;
	}

}
