
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import com.caribresort.database.BaseHibernate;
import com.caribresort.entity.*;

/**
 * Driver module to be used by application
 * */
public class Driver {

	public static void main(String[] args) {

		//insert
		//System.out.println(BaseHibernate.insert(new Armband("Orange")));
		
		//selectAll
//		List<Armband> rs = new ArrayList<Armband>();
//		rs = BaseHibernate.selectAll(new Armband());
//		for(Armband a : rs)
//			System.out.println(a);
		
		//select by id
		Armband b =BaseHibernate.find(Armband.class, 1);
		System.out.println(b);
		
		//update

	}
	
	

}
