package com.caribresort.factory;

import com.caribresort.actions.Request;
import com.caribresort.actions.RequestAction;
import com.caribresort.actions.Response;
import com.caribresort.database.ManagerDB;
import com.caribresort.entity.Drink;


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
		Drink newDrink = null;
		try{
        	newDrink = (Drink)request.getObject();
        }catch(ClassCastException e){
        	return new Response(true,new String[]{"Invalid Drink Format"},false);
        }
		if(ManagerDB.update(newDrink))
			return new Response(true,new String[]{},true);
		else
			return new Response(true,new String[]{"Unable to update drink"},false);

	}

	private Response removeDrink() {
        int drinkId = 0;
		try{
        	drinkId = (int)request.getObject();
        }catch(ClassCastException e){
        	return new Response(true,new String[]{"Please specify the drink Id number"},false);
        }
		if(ManagerDB.deleteDrink(drinkId))
			return new Response(true,new String[]{},true);
		else
			return new Response(true,new String[]{"Unable to delete drink"},false);
	}

	private Response viewDrinks() {
		return new Response(true,new String[0],ManagerDB.getAllDrinks().toArray());
	}

	private Response addDrink() {
		// TODO Auto-generated method stub
		return null;
	}

}
