package com.caribresort.entity;
// Generated Feb 25, 2014 2:21:24 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Drink generated by hbm2java
 */
public class Drink  implements CaribResortEntity {


     /**
	 * 
	 */
	private static final long serialVersionUID = -5068487621215742851L;
	private Integer drinkId;
     private Drinktype drinktype;
     private Integer drinkName;
     private Date createdDate;
     private Set<Customerorderitem> customerorderitems = new HashSet<Customerorderitem>(0);

    public Drink() {
    }

    public Drink(Drinktype drinktype, Integer drinkName, Date createdDate, Set<Customerorderitem> customerorderitems) {
       this.drinktype = drinktype;
       this.drinkName = drinkName;
       this.createdDate = createdDate;
       this.customerorderitems = customerorderitems;
    }
   
    public Integer getDrinkId() {
        return this.drinkId;
    }
    
    public void setDrinkId(Integer drinkId) {
        this.drinkId = drinkId;
    }
    public Drinktype getDrinktype() {
        return this.drinktype;
    }
    
    public void setDrinktype(Drinktype drinktype) {
        this.drinktype = drinktype;
    }
    public Integer getDrinkName() {
        return this.drinkName;
    }
    
    public void setDrinkName(Integer drinkName) {
        this.drinkName = drinkName;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Set<Customerorderitem> getCustomerorderitems() {
        return this.customerorderitems;
    }
    
    public void setCustomerorderitems(Set<Customerorderitem> customerorderitems) {
        this.customerorderitems = customerorderitems;
    }

	@Override
	public Object PopulateFromArray(Object[] data) {
		// TODO Auto-generated method stub
		return null;
	}




}


