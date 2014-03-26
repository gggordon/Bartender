package com.caribresort.database;

public interface NativeQueries {
	
	//General Queries
	String getAllDrinks="select d.* from drink d";
	
	
	//Customer Queries
	String addItemToOrder="insert into Customerorderitem (customerOrderId , drinkId, orderQuantity ) values ( :customerOrderId , :drinkId, :orderQuantity )";

	//Bartender Queries
	
	//Manager Queries
	String deleteDrink="delete from drink d where d.drinkId = :drinkId";
	
	String getRole="select r.roleName from employee e inner join role r on r.roleId = e.roleId where e.userName = :userName and  e.password = :password";
}
