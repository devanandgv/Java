package com.dev.java.collections.bo;

import java.util.List;

public class Order implements Comparable<Order>{

	
	private String orderId;
	private Customer customer;
	private List<Product> products;
	private Double billingAmount;
	private Address billingAddress;
	
	
	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Double getBillingAmount() {
		return billingAmount;
	}


	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}


	public Address getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}


	@Override
	public int compareTo(Order order) {
		

		if ( order == null || order.getOrderId() == null)
			return -1;
		
		return order.getOrderId().compareTo(this.orderId);
	}
	
}
