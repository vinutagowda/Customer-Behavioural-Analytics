package com.cts.cba.invoice.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "invoice")
@ApiModel(description = "Invoice Details")
public class Invoice {
	@Id
	@Column(name = "invoice_id")
	@ApiModelProperty(notes = "Invoice ID")
	private int invoiceId;

	@Column(name = "invoice_date", nullable = false)
	@ApiModelProperty(notes = "Invoice Date & Time")
	private LocalDateTime invoiceDate;

	@Column(name = "tax", nullable = false)
	@ApiModelProperty(notes = "GST")
	private double tax;

	@Column(name = "total_price", nullable = false)
	@ApiModelProperty(notes = "Shopping Amount")
	private double totalPrice;

	@Column(name = "payment_mode", nullable = false)
	@ApiModelProperty(notes = "Mode of Payment")
	private String paymentMode;

	@ManyToMany
	@JoinTable(name = "invoice_product", joinColumns = {
			@JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id", nullable = false), }, inverseJoinColumns = {
					@JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false) })
	@ApiModelProperty(notes = "List of Products Purchased")
	private List<Product> product;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	@ApiModelProperty(notes = "Customer Details")
	private Customer customer;

	public Invoice() {
	}

	public Invoice(int invoiceId, LocalDateTime invoiceDate, double tax, double totalPrice, String paymentMode,
			List<Product> product, Customer customer) {
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.tax = tax;
		this.totalPrice = totalPrice;
		this.paymentMode = paymentMode;
		this.product = product;
		this.customer = customer;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalDateTime getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDateTime invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}