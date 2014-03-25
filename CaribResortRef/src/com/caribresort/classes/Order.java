package com.caribresort.classes;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

public class Order {
     private int customerOrderId;
     private int personId;
     private Date orderDate;
     private List<OrderItem> items;
     
     public Order(){
    	 this(0,0,new Date(new java.util.Date().getTime()),new ArrayList<OrderItem>());
     }
     
	public Order(int customerOrderId, int personId, Date orderDate,
			List<OrderItem> items) {
		super();
		this.customerOrderId = customerOrderId;
		this.personId = personId;
		this.orderDate = orderDate;
		this.items = items;
	}
	
	public int getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addItem(OrderItem item){
		if(this.items==null)
			this.items = new ArrayList<OrderItem>();
		this.items.add(item);
	}
	
	public boolean removeItem(OrderItem item){
		if(this.items==null){
			this.items = new ArrayList<OrderItem>();
			return false; //item does not exists
		}
		return this.items.remove(item);
	}
	
	public boolean removeItemWithId(int id){
		OrderItem item = null;
		//TODO : Employ datastructures , treat list as ordered binary search tree
		
		//inefficient code below
		for(OrderItem b : this.items)
			if(b.getCustomerOrderItemId() == id){
				item = b;
				break;
			}
		
		return removeItem(item);
	}
	
	
     
     
}
