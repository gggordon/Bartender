package com.caribresort.database;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.caribresort.entity.*;
import com.caribresort.logging.DefaultLogger;

public class CustomerDB extends BaseHibernate {

	public static Boolean addItemToOrder(Customerorderitem cI){
		Boolean result = false;
		Session session = getSession();
		Transaction trans = null;        
		trans = session.beginTransaction();
		DefaultLogger.trace("Running native query : "+NativeQueries.addItemToOrder);

		try{
			result = session.createSQLQuery(NativeQueries.addItemToOrder)
					.setInteger("customerOrderId", cI.getCustomerorder().getCustomerOrderId())
					.setInteger("drinkId",cI.getDrink().getDrinkId())
					.setInteger("orderQuantity",cI.getOrderQuantity())
					.executeUpdate() != 0;
		}catch(Exception e){
			DefaultLogger.error("Error while executing "+NativeQueries.addItemToOrder, e);
		}
		trans.commit();
		session.close();
		return result;
	}

}


