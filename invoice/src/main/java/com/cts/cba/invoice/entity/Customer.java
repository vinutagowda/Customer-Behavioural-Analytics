package com.cts.cba.invoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "customer")
@ApiModel(description = "Details about customer")
public class Customer {
	@Id
	@Column(name = "customer_id")
	@ApiModelProperty(notes = "Customer ID")
	private int customerId;

	@Column(name = "customer_name", nullable = false)
	@ApiModelProperty(notes = "Customer Name")
	private String customerName;

	@Column(name = "customer_category", nullable = false)
	@ApiModelProperty(notes = "Customer Category")
	private String customerCategory;

	@Column(name = "location", nullable = false)
	@ApiModelProperty(notes = "Customer Location")
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