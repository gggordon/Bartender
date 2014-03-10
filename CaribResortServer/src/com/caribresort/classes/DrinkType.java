package com.caribresort.classes;

public class DrinkType {
    private int drinkTypeId;
    private String drinkTypeName;
       
    
	public DrinkType() {
		this(0,"");
	}

	public DrinkType(int drinkTypeId, String drinkTypeName) {
		super();
		this.drinkTypeId = drinkTypeId;
		this.drinkTypeName = drinkTypeName;
	}
	
	public int getDrinkTypeId() {
		return drinkTypeId;
	}
	public void setDrinkTypeId(int drinkTypeId) {
		this.drinkTypeId = drinkTypeId;
	}
	public String getDrinkTypeName() {
		return drinkTypeName;
	}
	public void setDrinkTypeName(String drinkTypeName) {
		this.drinkTypeName = drinkTypeName;
	}

	@Override
	public String toString() {
		return "{drinkTypeId:" + drinkTypeId + ", drinkTypeName:'"
				+ drinkTypeName + "'}";
	}
    
    
    
}
