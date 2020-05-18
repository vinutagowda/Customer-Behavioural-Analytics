package com.cts.cba.dashboard.model;

public class Customer {

	private int customerId;
	private String customerName;
	private String customerCategory;
	private String location;

	public Customer() {
	}

	public Customer(int customerId, String customerName, String customerCategory, String location) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerCategory = customerCategory;
		this.location = location;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}