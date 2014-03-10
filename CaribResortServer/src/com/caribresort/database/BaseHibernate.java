package com.caribresort.database;


import java.util.ArrayList;
import java.util.List;

import com.caribresort.entity.CaribResortEntity;
import com.caribresort.logging.DefaultLogger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

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
    	List<Object[]> results = null;
        Session session = getSession();
        Transaction trans = null;        
        trans = session.beginTransaction();
        DefaultLogger.trace("Selecting all "+getClassName(object.getClass()));

        results = session.createSQLQuery("select * from "+getClassName(object.getClass())).list();
        trans.commit();
        session.close();
        try{
        	List<T> objects = new ArrayList<T>();
        	for(Object[] rs : results){
        		objects.add((T) object.PopulateFromArray(rs));
        	}
        	return objects;
        }catch(Exception e){
        	DefaultLogger.error("Error while populating from array", e);
        	return null;
        }
        
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
}
