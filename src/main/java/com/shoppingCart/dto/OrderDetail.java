package com.shoppingCart.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
@Table(name="Order_Detail")
public class OrderDetail implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_detail_id")
	private int orderDetailId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
	private float price;
	
	@Column(name="tax")
	private int tax;

	@Column(name="deleted")
	private boolean deleted;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "bill_id")
	private Bill bill;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	public OrderDetail() {
		super();
		this.bill = new Bill();
		this.product = new Product();
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}


	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
