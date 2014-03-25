package com.caribresort.classes;

import java.sql.Date;

public class Drink {
   
	private int drinkId;
	private String drinkName;
	private int quantity;
	private Date createdDate;
	private DrinkType drinkType;
	
	public Drink(){
		this(0,"",0,new Date(new java.util.Date().getTime()),new DrinkType());
	}
	
	public Drink(int drinkId, String drinkName, int quantity, Date createdDate,
			DrinkType drinkType) {
		super();
		this.drinkId = drinkId;
		this.drinkName = drinkName;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.drinkType = drinkType;
	}
	public int getDrinkId() {
		return drinkId;
	}
	public void setDrinkId(int drinkId) {
		this.drinkId = drinkId;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if(quantity < 0){
			//TODO : Decide whether to throw an error for illogical value (quantity < 0)
			return;
		}
		this.quantity = quantity;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public DrinkType getDrinkType() {
		return drinkType;
	}
	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}

	@Override
	public String toString() {
		return "{drinkId : " + drinkId + ", drinkName:" + drinkName
				+ ", quantity:" + quantity + ", createdDate:'" + createdDate
				+ "', drinkType:" + drinkType + "}";
	}
	
	
	
	
}
