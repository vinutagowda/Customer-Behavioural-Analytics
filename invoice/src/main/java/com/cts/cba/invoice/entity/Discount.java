package com.cts.cba.invoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "discount")
@ApiModel(description = "Discount Details")
public class Discount {
	@Id
	@Column(name = "did")
	@ApiModelProperty(notes = "Discount ID")
	private int discountId;

	@Column(name = "dname", nullable = false)
	@ApiModelProperty(notes = "Discount Name")
	private String discountName;

	@Column(name = "descr")
	@ApiModelProperty(notes = "Discount Description")
	private String description;

	@Column(name = "dprice", nullable = false)
	@ApiModelProperty(notes = "Discount Price")
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