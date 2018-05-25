package com.shoppingCart.dto;



public class ShoppingCart {
	private String cartGuid;
	private int quantity;
	private Product product;

	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCart(String cartGuid, int quantity,Product product) {
		super();
		this.cartGuid = cartGuid;
		this.quantity = quantity;
		this.product = product;
	}
	public String getCartGuid() {
		return cartGuid;
	}
	public void setCartGuid(String cartGuid) {
		this.cartGuid = cartGuid;
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
	public void setProducts(Product product) {
		this.product = product;
	}
}
