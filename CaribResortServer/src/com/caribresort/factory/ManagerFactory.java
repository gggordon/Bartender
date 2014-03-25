package com.caribresort.factory;

import com.caribresort.actions.Request;
import com.caribresort.actions.RequestAction;
import com.caribresort.actions.Response;


public class ManagerFactory extends AbstractFactory {

	public ManagerFactory(Request request){
		this.request = request;
	}
	
	@Override
	public Response processRequest() {
		Response response = invalidResponse;
		switch(request.getAction()){
		case RequestAction.ADDDRINK:
			response= addDrink();
			break;
		case RequestAction.VIEWDRINKS:
			response= viewDrinks();
			break;
			
		case RequestAction.REMOVEDRINK:
			response= removeDrink();
			break;
		case RequestAction.UPDATEDRINK:
			response= updateDrink();
			break;
		case RequestAction.GENERATEREPORT:
			response= generateReport();
			break;
		}
		return response==null?AbstractFactory.invalidResponse:response;
	}

	private Response generateReport() {
		// TODO Auto-generated method stub
		return null;
	}

	private Response updateDrink() {
		// TODO Auto-generated method stub
		return null;
	}

	private Response removeDrink() {
		// TODO Auto-generated method stub
		return null;
	}

	private Response viewDrinks() {
		// TODO Auto-generated method stub
		return null;
	}

	private Response addDrink() {
		// TODO Auto-generated method stub
		return null;
	}

}
