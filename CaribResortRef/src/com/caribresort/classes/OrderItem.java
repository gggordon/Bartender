package com.caribresort.classes;

public class OrderItem {
     private int customerOrderItemId;
     private int customerOrderId;
     private String served;
     //TODO : Determine how ORM Tool works and add if necessary
     //private int drinkId;     
     private Drink drink;
     
     
	public OrderItem(int customerOrderItemId, int customerOrderId, Drink drink, String served) {
		super();
		this.customerOrderItemId = customerOrderItemId;
		this.customerOrderId = customerOrderId;
		this.served = served;
		this.drink = drink;
	}
	
	public OrderItem() {
		this(0,0,new Drink(),"open");
	}

	public int getCustomerOrderItemId() {
		return customerOrderItemId;
	}
	public void setCustomerOrderItemId(int customerOrderItemId) {
		this.customerOrderItemId = customerOrderItemId;
	}
	public int getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public boolean isServed() {
		return served=="served";
	}
	
	@SuppressWarnings("unused") //TODO : remove if not being used by ORM Tool
	private void setServed(String served){
		this.served = served;
	}
	
	@SuppressWarnings("unused") //TODO : remove if not being used by ORM Tool
	private String getServed(){
		return this.served;
	} 

	public void Serve() {
		this.served = "served";
	}
	
	public void Open() {
		this.served = "open";
	}

	public Drink getDrink() {
		return drink;
	}
	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	@Override
	public String toString() {
		return "{customerOrderItemId:" + customerOrderItemId
				+ ", customerOrderId:" + customerOrderId + ", served : '"+served+"',drink:" + drink
				+ "}";
	}
	
     
     
}
