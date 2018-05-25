package com.shoppingCart.dto;

public class OrderDetail {

	private Product product;
	private int id, quantity;
	private float price;

	public OrderDetail() {
		super();

	}

	public OrderDetail(Product product, int id, int quantity, float price) {
		super();
		this.product = product;
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	};

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
