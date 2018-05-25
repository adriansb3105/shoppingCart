package com.shoppingCart.dto;

import java.sql.Date;
import java.util.List;

public class Order {
	
private List<OrderDetail> orderDetails;
private  OrderStatus orderStatus;
private int id;
private String transactionId;
private Date date, shipDate;
private int  trackingNumber;
private float totalvalue;

public Order() {
	super();
	// TODO Auto-generated constructor stub
}

public Order(List<OrderDetail> orderDetails, OrderStatus orderStatus, int id, String transactionId, Date date,
		Date shipDate, int trackingNumber, float totalvalue) {
	super();
	this.orderDetails = orderDetails;
	this.orderStatus = orderStatus;
	this.id = id;
	this.transactionId = transactionId;
	this.date = date;
	this.shipDate = shipDate;
	this.trackingNumber = trackingNumber;
	this.totalvalue = totalvalue;
}

public List<OrderDetail> getOrderDetails() {
	return orderDetails;
}

public void setOrderDetails(List<OrderDetail> orderDetails) {
	this.orderDetails = orderDetails;
}

public OrderStatus getOrderStatus() {
	return orderStatus;
}

public void setOrderStatus(OrderStatus orderStatus) {
	this.orderStatus = orderStatus;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTransactionId() {
	return transactionId;
}

public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Date getShipDate() {
	return shipDate;
}

public void setShipDate(Date shipDate) {
	this.shipDate = shipDate;
}

public int getTrackingNumber() {
	return trackingNumber;
}

public void setTrackingNumber(int trackingNumber) {
	this.trackingNumber = trackingNumber;
}

public float getTotalvalue() {
	return totalvalue;
}

public void setTotalvalue(float totalvalue) {
	this.totalvalue = totalvalue;
}


}
