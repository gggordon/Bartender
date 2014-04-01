package com.caribresort.database;

public class NativeQueries {
	
	//General Queries
	public static final  String getAllDrinks="select d.* from drink d";
	public static final  String getRole="select r.roleName from employee e inner join role r on r.roleId = e.roleId where e.userName = :userName and  e.password = :password";
	
	//Customer Queries
	public static final  String addItemToOrder="insert into Customerorderitem (customerOrderId , drinkId, orderQuantity ) values ( :customerOrderId , :drinkId, :orderQuantity )";

	//Bartender Queries
	
	//Manager Queries
	public static final  String deleteDrink="delete from drink d where d.drinkId = :drinkId";
	public static final  String frequencyReport = "select cI.drinkId, d.drinkName, SUM(cI.orderQuantity) as amt, DATE(cO.orderDate) as orderDate from Customerorderitem cI inner join Drink d on d.drinkId = cI.drinkId inner join Customerorder cO on cO.customerOrderId = cI.customerOrderId where DATE(cO.orderDate) between :dateStart and :dateEnd group by cI.drinkId order by DATE(cO.orderDate) asc, SUM(cI.orderQuantity) desc";
	public static final  String mostFrequentDrinks="select cI.drinkId, d.drinkName, SUM(cI.orderQuantity) as amt from Customerorderitem cI inner join Drink d on d.drinkId = cI.drinkId group by cI.drinkId order by SUM(cI.orderQuantity) desc";
	
	
	//ManagerCRUD queries
	//Delete Queries
	public static final  String deleteArmband="delete from Armband a where a.armBandId = :id";
	public static final  String deleteCustomerorder="delete from Customerorder c where c.customerOrderId = :id";
	public static final  String deleteCustomerorderitem ="delete from Customerorderitem c where c.customerOrderItemId = :id";
	public static final  String deleteDrinkType="delete from Drinktype a where a.drinkTypeId = :id";
	public static final  String deleteEmployee="delete from Employee e where e.employeeId = :id";
	public static final  String deleteGuest="delete from Guest e where e.guestId = :id";
	public static final  String deleteRole="delete from Role e where e.roleId = :id";
}
