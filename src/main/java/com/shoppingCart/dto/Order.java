package com.shoppingCart.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="total_value")
	private float totalValue;
	
	private List<OrderDetail> orderDetails;
	

	

}
