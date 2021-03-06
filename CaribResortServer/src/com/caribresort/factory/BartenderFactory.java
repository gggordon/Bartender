package com.caribresort.factory;

import com.caribresort.actions.Request;
import com.caribresort.actions.RequestAction;
import com.caribresort.actions.Response;
import com.caribresort.database.BartenderDB;


public class BartenderFactory extends AbstractFactory{
	public BartenderFactory(Request request){
		this.request = request;
	}

	@Override
	public Response processRequest() {
		Response response = invalidResponse;
		switch(request.getAction()){
		case RequestAction.SERVE:
			response= serveDrink();
			break;
		case RequestAction.OPEN:
			response= openDrink();
			break;
		}
		return response;
	}
	//TODO : Determine which object stores served status
	private Response openDrink() {
		if(BartenderDB.openDrink())
			return new Response(true,new String[]{},true);
		else
			return new Response(true,new String[]{"Unable to open Drink"},false);
	}

	private Response serveDrink() {
		if(BartenderDB.serveDrink())
			return new Response(true,new String[]{},true);
		else
			return new Response(true,new String[]{"Unable to serve Drink"},false);
	}


}
