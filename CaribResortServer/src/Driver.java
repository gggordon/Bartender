
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.caribresort.actions.*;
import com.caribresort.database.BaseHibernate;
import com.caribresort.entity.*;
import com.caribresort.factory.UserFactory;

/**
 * Driver module to be used by application
 * */
public class Driver {

	public static void main(String[] args) {

		String request="GETDRINK";
		System.out.println(
				String.valueOf( request.charAt(3)) +request.substring(4).toLowerCase()
				);
		//insert
		//System.out.println(BaseHibernate.insert(new Armband("Orange")));

		//selectAll
		//		List<Armband> rs = new ArrayList<Armband>();
		//		rs = BaseHibernate.selectAll(new Armband());
		//		for(Armband a : rs)
		//			System.out.println(a);

		//select by id
		/*
		Request req = new Request();
		req.setAction(RequestAction.ADDDRINK);
		req.setPassword("123456");
		req.setUsername("keric");
		
		req.setObject(new Drink(CaribResortEntity.ALCOHOLIC,"guinness",new Date()) );
		try{
			Response resp=UserFactory.GetFactory(req);
			try{
				
                System.out.println(resp);
                System.out.println((Boolean)resp.getResult());
                /* 
                 * Viewing retrieved drinks
                 * 
                 * drinks[] = (Object[]) resp.getResult();
                if(drinks == null)
                	System.out.println("Drinks is null");
                if(drinks != null)
				for(int i=0;i<drinks.length;i++){
					try{
						Drinktype d = (Drinktype)drinks[i];
						System.out.println(d);
					}catch(Exception e){
						e.printStackTrace();
					}
				}*//*

			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//update

		*/
	}



}
