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

@Entity
@Table(name="Order_Detail")
public class OrderDetail {

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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "order_id")
	@JsonIgnore
	private Order order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;
	
	

}
