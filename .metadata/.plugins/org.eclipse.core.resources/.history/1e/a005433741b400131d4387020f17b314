package com.caribresort.factory;

import com.caribresort.actions.Request;
import com.caribresort.actions.RequestAction;
import com.caribresort.actions.Response;

public class GuestFactory extends AbstractFactory {

	
	public GuestFactory(Request request){
		this.request = request;
	}
	@Override
	public Response processRequest() {
		Response response = invalidResponse;
		switch(request.getAction()){
		case RequestAction.MAKEORDER:
			response= makeOrder();
			break;
		case RequestAction.ADDITEMTOORDER:
			response= addItemToOrder();
			break;
		}
		return response==null?invalidResponse:response;
	}
	
	private Response makeOrder(){
		//TODO : Implement make order
		return null;
	}
	
	private Response addItemToOrder(){
		//TODO : Implement add item to order
		return null;
	}

}
