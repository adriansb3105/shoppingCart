package com.shoppingCart.dto;

public class Product {
	private int id, price;
	private String image, description;
	private float unitsOnStock;
	private Category category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, int price, String image, String description, float unitsOnStock, Category category) {
		super();
		this.id = id;
		this.price = price;
		this.image = image;
		this.description = description;
		this.unitsOnStock = unitsOnStock;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getUnitsOnStock() {
		return unitsOnStock;
	}

	public void setUnitsOnStock(float unitsOnStock) {
		this.unitsOnStock = unitsOnStock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
}
