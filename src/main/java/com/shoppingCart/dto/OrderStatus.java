package com.shoppingCart.dto;

public class OrderStatus {
private int id;
private String name;

public OrderStatus(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public OrderStatus() {
	super();
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
