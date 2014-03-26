package com.caribresort.factory;

import com.caribresort.actions.Request;
import com.caribresort.actions.Response;
import com.caribresort.database.BaseHibernate;;

public class UserFactory {

	public static Response GetFactory(Request request){
		switch(login(request.getUsername(),request.getPassword())){
		case UserType.User:
			return new GuestFactory(request).processRequest();
		case UserType.Bartender:
			return new BartenderFactory(request).processRequest();
		case UserType.Manager:
			return new ManagerFactory(request).processRequest();
		default:
			return AbstractFactory.invalidResponse;
		}

	}
	
	/**
	 * @return String userType
	 * */
	private static String login(String username, String password){
		return BaseHibernate.getRole(username, password);
	}
	
	
}
