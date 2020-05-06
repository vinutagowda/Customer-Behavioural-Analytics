package com.cts.cba.dashboard.model;

import java.util.Set;

public class Customer {

	private int customerId;
	private String customerName;
	private String customerCategory;
	private String location;

	private Set<Invoice> invoice;

	public Customer() {
	}

	public Customer(int customerId, String customerName, String customerCategory, String location,
			Set<Invoice> invoice) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerCategory = customerCategory;
		this.location = location;
		this.invoice = invoice;
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

	public Set<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
	}

}