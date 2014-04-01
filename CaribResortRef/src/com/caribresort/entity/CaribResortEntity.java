package com.caribresort.entity;

import java.io.Serializable;

public interface CaribResortEntity extends Serializable{

	/**
	 * 
	 * Implementing Class must create a temporary instance of itself 
	 * before checking and assigning indexed locations to respective 
	 * Variables in temporary object before returning temporary object
	 * */
	public Object PopulateFromArray(Object[] data);
	
	public Drinktype ALCOHOLIC = new Drinktype(1,"alcoholic");
	public Drinktype NONALCOHOLIC = new Drinktype(2,"non-alcoholic");
}
