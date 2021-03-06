package com.caribresort.factory;

import java.util.ArrayList;

import com.caribresort.actions.Request;
import com.caribresort.actions.RequestAction;
import com.caribresort.actions.Response;
import com.caribresort.database.CustomerDB;
import com.caribresort.entity.Customerorder;
import com.caribresort.entity.Customerorderitem;
import com.caribresort.logging.DefaultLogger;

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
		case RequestAction.VIEWDRINKS:
			response = viewDrinks();
			break;
		}
		return response==null?invalidResponse:response;
	}
	
	
	
	private Response makeOrder(){
		ArrayList<String> errors = new ArrayList<String>();  
		try{			
			
			Customerorder cOrder=(Customerorder)request.getObject();
			if(!CustomerDB.insert(cOrder))
			{
			    throw new Exception("Unable to save order");	
			}else{
				for(Customerorderitem c : cOrder.getCustomerorderitems()){
					try{
						c.setCustomerorder(cOrder);
						if(!CustomerDB.insert(c))
							throw new Exception("Unable to add item to order");
					}catch(Exception e){
						
						DefaultLogger.error("Unable to add item to order |", e);
						errors.add("Unable to add "+c.getDrink().getDrinkName()+" to order");
					}
				}
			}
			
		}
		catch(Exception e){
			errors.add("Unable to add order");
		    DefaultLogger.error("Unable to add order",e);	
		}
		
		return new Response(true,(String[]) errors.toArray(),true);
	}
	
	private Response addItemToOrder(){
		ArrayList<String> errors = new ArrayList<String>();  
		try{			
			
			Customerorderitem cItem=(Customerorderitem)request.getObject();
			if(!CustomerDB.addItemToOrder(cItem))
				throw new Exception("Unable to add item to order");
			
		}
		catch(Exception e){
			errors.add("Unable to add item to order");
		    DefaultLogger.error("Unable to add item to order",e);	
		}
		
		return new Response(true,(String[]) errors.toArray(),true);
	}

}
