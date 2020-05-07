package com.cts.cba.invoice.model;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
	private int invoiceId;
	private LocalDate invoiceDate;
	private double tax;
	private double totalPrice;
	private String paymentMode;

	private List<Product> product;

	private Customer customer;

	public Invoice() {
	}

	public Invoice(int invoiceId, LocalDate invoiceDate, double tax, double totalPrice, String paymentMode,
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

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
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