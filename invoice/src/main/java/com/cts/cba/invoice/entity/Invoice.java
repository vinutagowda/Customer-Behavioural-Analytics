package com.cts.cba.invoice.entity;

import java.time.LocalDate;
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
	@Column(name = "iid")
	@ApiModelProperty(notes = "Invoice ID")
	private int invoiceId;

	@Column(name = "idate", nullable = false)
	@ApiModelProperty(notes = "Invoice Date")
	private LocalDate invoiceDate;

	@ManyToOne
	@ApiModelProperty(notes = "Customer details")
	private Customer customer;

	@Column(name = "qty", nullable = false)
	@ApiModelProperty(notes = "Invoice Quantity")
	private int quantity;

	@Column(name = "tax", nullable = false)
	@ApiModelProperty(notes = "GST")
	private double tax;

	@Column(name = "tprice", nullable = false)
	@ApiModelProperty(notes = "Shopping Amount")
	private double totalPrice;

	@Column(name = "paymode", nullable = false)
	@ApiModelProperty(notes = "Mode of Payment")
	private String paymentMode;

	@ManyToMany
	@JoinTable(name = "invoice_product", joinColumns = {
			@JoinColumn(name = "iid", referencedColumnName = "iid", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "pid", referencedColumnName = "pid", nullable = false) })
	@ApiModelProperty(notes = "List of Products Purchased")
	private List<Product> product;

	public Invoice() {
	}

	public Invoice(int invoiceId, LocalDate invoiceDate, Customer customer, int quantity, double tax, double totalPrice,
			String paymentMode, List<Product> product) {
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.customer = customer;
		this.quantity = quantity;
		this.tax = tax;
		this.totalPrice = totalPrice;
		this.paymentMode = paymentMode;
		this.product = product;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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