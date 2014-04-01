package com.caribresort.database;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

import com.caribresort.entity.CaribResortEntity;
import com.caribresort.entity.Drink;
import com.caribresort.logging.DefaultLogger;

@SuppressWarnings("deprecation") 
public class BaseHibernate {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml) 
			Configuration configuration = new Configuration();
			configuration=configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
            
		} catch (Throwable ex) {
			DefaultLogger.error("Initialization failed", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	protected static Session getSession() {
		return sessionFactory.openSession();
	}

	/**
	 * Insert hibernate object
	 * */
	public static <T extends CaribResortEntity> Boolean insert(T object){
		Session session = getSession();
		Transaction trans = null; 
		try{
			trans = session.beginTransaction();
			DefaultLogger.trace("Started Transaction to save "+ object.getClass().getName()  );
			session.save(object);
			trans.commit();
			DefaultLogger.trace("Transaction to save "+object.getClass().getName()+" completed successfully");
			return true;
		}catch(RuntimeException re){
			DefaultLogger.error("Error occured while saving "+object, re);
			if(trans != null){
				trans.rollback();
			}
		}catch(Exception e){
			DefaultLogger.error("Error occured while saving "+object, e);
			if(trans != null){
				trans.rollback();
			}
		}finally{
			session.flush();
			session.close();
		}

		return false;
	}

	public static <T extends CaribResortEntity> Boolean delete(T object){
		Session session = getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			DefaultLogger.trace("Started Transaction to delete "+object.getClass().getName());

			session.delete(object);
			trans.commit();
			DefaultLogger.info("Delete transaction completed successfully");
			return true;
		} catch (RuntimeException ex) {
			DefaultLogger.error("Exception occurred while deleting "+ object.getClass().getName(),ex);
			if (trans != null) {
				trans.rollback();
			}

		} catch(Exception e){
			DefaultLogger.error("Error occured while deleting "+object, e);
			if(trans != null){
				trans.rollback();
			}
		}finally {
			session.flush();
			session.close();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static <T extends CaribResortEntity> List<T> selectAll(T object){
		List<T> results = null;
		Session session = getSession();
		Transaction trans = null;        
		trans = session.beginTransaction();
		DefaultLogger.trace("Selecting all "+getClassName(object.getClass()));

		results = session.createQuery("from "+getClassName(object.getClass())).list();
		trans.commit();
		session.close();
		return results;

	}

	private static String getClassName(Class<? extends CaribResortEntity> clazz){
		return clazz.getName().substring(clazz.getName().lastIndexOf(".")+1);		
	}

	public static <T extends CaribResortEntity> T find(Class clazz, int id){
		T object = null;
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		DefaultLogger.info("Selecting "+getClassName(clazz)+" with id : "+id  );
		object = (T) session.get(clazz, id);        
		trans.commit();
		session.close();
		return object;
	}

	//TODO : not completely logical ? Research and find out how Hibernate Persistence Context Works
	public static <T extends CaribResortEntity> Boolean update(T object){
		Session session = getSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			DefaultLogger.trace("Started Transaction to update "+object.getClass().getName());
			session.update(object);
			trans.commit();
			DefaultLogger.info("Update transaction completed successfully");
			return true;
		} catch (RuntimeException ex) {
			DefaultLogger.error("Exception occurred while updating "+ object.getClass().getName(),ex);
			if (trans != null) {
				trans.rollback();
			}

		} catch(Exception e){
			DefaultLogger.error("Error occured while updating "+object, e);
			if(trans != null){
				trans.rollback();
			}
		}finally {
			session.flush();
			session.close();
		}
		return false;
	}

	public static List<Object[]> nativeQuery(String sql){
		List<Object[]> results = null;
		Session session = getSession();
		Transaction trans = null;        
		trans = session.beginTransaction();
		DefaultLogger.trace("Running native query : "+sql);

		results = session.createSQLQuery(sql).list();
		trans.commit();
		session.close();
		return results;


	}

	public static Boolean nativeQueryUpdate(String sql){
		Boolean result = false;
		Session session = getSession();
		Transaction trans = null;        
		trans = session.beginTransaction();
		DefaultLogger.trace("Running native query : "+sql);

		result = session.createSQLQuery(sql).executeUpdate() != 0;
		trans.commit();
		session.close();
		return result;    	
	}

	public static List<Object> getAllDrinks(){
		List<Object> drinks = new ArrayList<Object>();
		Session session = getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			Query query = session.createQuery("from Drink");
			drinks = query.list();
			trans.commit();
		}catch(Exception e){
			if(trans != null)
				trans.rollback();
			DefaultLogger.error("Unable to get all drinks",e);
		}
		return drinks;
	}
	
	public static List<Object> getAllDrinkType(){
		List<Object> drinks = new ArrayList<Object>();
		Session session = getSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			Query query = session.createQuery("from Drinktype");
			drinks = query.list();
			trans.commit();
		}catch(Exception e){
			if(trans != null)
				trans.rollback();
			DefaultLogger.error("Unable to get all drink types",e);
		}
		return drinks;
	}

	public static String getRole(String username, String password){
		Session session = getSession();
		try{
			List<Object> results =session.createSQLQuery(NativeQueries.getRole)
					.setString("userName", username)
					.setString("password", password)
					.list();
			if(results!= null)
				if(results.size()>0)
					return results.get(0).toString();
		}catch(Exception e){
			DefaultLogger.error("Unable to run getRole Query",e);

		}

		return "User";
	}


}
