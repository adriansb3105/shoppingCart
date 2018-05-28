package com.shoppingCart.dto;
import java.util.List;

public class ShoppingCart {
	private String cartGuid;
	private int quantity;
	private List<Product> products;

	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingCart(String cartGuid, int quantity, List<Product> products) {
		super();
		this.cartGuid = cartGuid;
		this.quantity = quantity;
		this.products = products;
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
	public List<Product> getProduct() {
		return products;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
