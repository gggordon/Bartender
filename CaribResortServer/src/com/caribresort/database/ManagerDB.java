package com.caribresort.database;

import java.util.List;

import com.caribresort.entity.Armband;
import com.caribresort.entity.Customerorder;
import com.caribresort.entity.Customerorderitem;
import com.caribresort.entity.Drinktype;
import com.caribresort.entity.Employee;
import com.caribresort.entity.Guest;
import com.caribresort.entity.Role;

public class ManagerDB extends BaseHibernate {

	public static Boolean deleteDrink(int id) {
		return false;
	}

	// select all

	public static List<Armband> getAllArmband() {
		return ManagerDB.selectAll(new Armband());
	}

	public static List<Customerorder> getAllCustomerorder() {
		return ManagerDB.selectAll(new Customerorder());
	}

	public static List<Customerorderitem> getAllCustomerorderitem() {
		return ManagerDB.selectAll(new Customerorderitem());
	}

	public static List<Drinktype> getAllDrinktype() {
		return ManagerDB.selectAll(new Drinktype());
	}

	public static List<Employee> getAllEmployee() {
		return ManagerDB.selectAll(new Employee());
	}

	public static List<Guest> getAllGuest() {
		return ManagerDB.selectAll(new Guest());
	}

	public static List<Role> getAllRole() {
		return ManagerDB.selectAll(new Role());
	}

}
