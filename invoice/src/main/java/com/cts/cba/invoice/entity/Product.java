package com.cts.cba.invoice.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "product")
@ApiModel(description = "Product Details")
public class Product {
	@Id
	@Column(name = "pid")
	@ApiModelProperty(notes = "Product ID")
	private int productId;

	@Column(name = "pname", nullable = false)
	@ApiModelProperty(notes = "Product Name")
	private String productName;

	@Column(name = "category", nullable = false)
	@ApiModelProperty(notes = "Product Category")
	private String category;

	@Column(name = "brand", nullable = false)
	@ApiModelProperty(notes = "Product Brand")
	private String brand;

	@Column(name = "descr")
	@ApiModelProperty(notes = "Product Description")
	private String description;

	@Column(name = "price", nullable = false)
	@ApiModelProperty(notes = "Product Price")
	private double price;

	@Column(name = "stock", nullable = false)
	@ApiModelProperty(notes = "Product Stock")
	private int stock;

	@ManyToMany
	@JoinTable(name = "product_discount", joinColumns = {
			@JoinColumn(name = "pid", referencedColumnName = "pid", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "did", referencedColumnName = "did", nullable = false) })
	@ApiModelProperty(notes = "List of discounts on Product")
	private Set<Discount> discount;

	public Product() {
	}

	public Product(int productId, String productName, String category, String brand, String description, double price,
			int stock, Set<Discount> discount) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.discount = discount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Set<Discount> getDiscount() {
		return discount;
	}

	public void setDiscount(Set<Discount> discount) {
		this.discount = discount;
	}

}