package com.shoppingCart.dto;

public class Address {

	private int id;
	private String description, city,state,postCode;
	
	public Address() {
		super();
		
	}
	public Address(int id, String description, String city, String state, String postCode) {
		super();
		this.id = id;
		this.description = description;
		this.city = city;
		this.state = state;
		this.postCode = postCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
