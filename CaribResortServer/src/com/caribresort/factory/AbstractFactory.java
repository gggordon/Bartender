package com.caribresort.factory;

import com.caribresort.actions.Request;
import com.caribresort.actions.Response;

abstract public class AbstractFactory {
    protected Request request=null;	
    protected static Response invalidResponse=new Response(false,new String[]{"INVALID_ACTION"},null);
    
    
    
    public abstract Response processRequest();
    
	public void setRequest(Request request) {
		this.request = request;
	}
	
	public Request getRequest() {
		return request;
	}
}
