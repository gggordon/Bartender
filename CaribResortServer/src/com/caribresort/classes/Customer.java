package com.caribresort.classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
	private ArmBand armband;	
	private List<Order> orders;
	
	public Customer() {
		super();
		this.armband = new ArmBand();
		this.orders = new ArrayList<Order>();
	}


	public Customer(int personId, String firstName, String lastName,
			String email, Date dateOfBirth, Date createdDate, Date lastLoginDate, ArmBand armband, List<Order> orders) {
		super(personId, firstName, lastName, email, dateOfBirth, createdDate,
				lastLoginDate);

		this.armband = armband;
		this.orders = orders;
	}


	public ArmBand getArmband() {
		return armband;
	}


	public void setArmband(ArmBand armband) {
		this.armband = armband;
	}


	@Override
	public String toString() {
		return "{armband:" + armband + ", person : "+super.toString()+"}";
	}
	
	
	
	//TODO : Implement Customer functions
	public void MakeOrder(Order order){
		
	}
	
	private Order getOrder(int orderId){
		//TODO : Improve asymptotic efficiency
		for(Order b : this.orders)
			if(b.getCustomerOrderId() == orderId)
				return b;
		return null;
	}
	
	public boolean addItemToOrder(int orderId, OrderItem item){
		Order order = this.getOrder(orderId);
		if(order != null){
			order.addItem(item);
			return true;
		}
		return false;
	}
	
	public String checkOrderStatus(int orderId){
		Order order = this.getOrder(orderId);
		if(order != null){
			
			int served=0;
			for(OrderItem l : order.getItems())
				if(l.isServed())
					served++;
			return served+" out of "+order.getItems().size()+" item (s) served"; 
		}
		return "This order is yet to be made";		
	}
}
