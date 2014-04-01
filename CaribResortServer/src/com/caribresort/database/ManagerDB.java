package com.caribresort.database;

import java.util.List;

import com.caribresort.entity.Armband;
import com.caribresort.entity.CaribResortEntity;
import com.caribresort.entity.Customerorder;
import com.caribresort.entity.Customerorderitem;
import com.caribresort.entity.Drinktype;
import com.caribresort.entity.Employee;
import com.caribresort.entity.Guest;
import com.caribresort.entity.Role;
import com.caribresort.entity.viewmodels.ManagerReportVM;
import com.caribresort.entity.viewmodels.ManagerReportVM.FrequencyReportRecord;
import com.caribresort.logging.DefaultLogger;

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

	public static ManagerReportVM getManagerReport(java.sql.Date dateStart, java.sql.Date dateEnd){
		ManagerReportVM report = new ManagerReportVM();
		try{
			//Retrieving Frequency Report
			String query = NativeQueries.frequencyReport;
			query.replaceFirst(":dateStart","'"+dateStart.toString()+"'");
			query.replaceFirst(":dateEnd","'"+dateEnd.toString()+"'");
			List<Object[]> results = ManagerDB.nativeQuery(query);
			if(results != null)
				if(results.size() > 0){
					try{
						for(Object[] res : results){
							report.addFrequencyReportRecord(report.new FrequencyReportRecord(res));  
						}
					}catch(Exception e){
						DefaultLogger.error("Frequency report query returned less than expected columns",e);
						throw e;
					}
				}
			//Retrieving Frequency Report
			results = ManagerDB.nativeQuery(NativeQueries.mostFrequentDrinks);
			if(results != null)
				if(results.size() > 0){
					try{
						for(Object[] res : results){
							report.addFrequencyDrinkRecord(report.new FrequencyDrinkRecord(res));  
						}
					}catch(Exception e){
						DefaultLogger.error("Frequency report query returned less than expected columns",e);
						throw e;
					}
				}
			
		}catch(Exception e){
			DefaultLogger.error("Unable to create Manager Report",e);
			report = null;
		}
		return report;
	}
	
	public static Boolean deleteEntity(int id,Class clazz){
		
		CaribResortEntity ent = ManagerDB.find(clazz, id);
		if(ent == null)
			return false;
		return ManagerDB.delete(ent);		
     }

}
