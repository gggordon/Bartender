package com.caribresort.factory;

import java.util.List;

import com.caribresort.actions.Request;
import com.caribresort.actions.Response;
import com.caribresort.database.CustomerDB;

abstract public class AbstractFactory {
    protected Request request=null;	
    public static final Response invalidResponse=new Response(false,new String[]{"INVALID_ACTION"},null);
    
    
    
    public abstract Response processRequest();
    
	public void setRequest(Request request) {
		this.request = request;
	}
	
	public Request getRequest() {
		return request;
	}
	
	protected Response viewDrinks() {
		List<Object> drinks = CustomerDB.getAllDrinks();

		return new Response(drinks.toArray());
	}
	
	protected Response viewDrinkTypes() {
		List<Object> types = CustomerDB.getAllDrinkType();
		return new Response(types.toArray());
	}
}
