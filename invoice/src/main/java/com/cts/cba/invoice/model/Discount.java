package com.cts.cba.invoice.model;

public class Discount {
	private int discountId;
	private String discountName;
	private String description;
	private double discountPrice;

	public Discount() {
	}

	public Discount(int discountId, String discountName, String description, double discountPrice) {
		this.discountId = discountId;
		this.discountName = discountName;
		this.description = description;
		this.discountPrice = discountPrice;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

}