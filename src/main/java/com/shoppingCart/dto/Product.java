package com.shoppingCart.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private float price;
	
	/*
	 * //@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL,mappedBy = "product")
	 * //@JsonIgnore
	 * //private Inventory inventory;
     */
	
	//@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
	//@JoinColumn(name = "category_id")
	//@JsonIgnore
	//private Category category;
	@Column(name="category_id")
	private int categoryId;

	//@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	//private List<ProductImage> productImages;
	
	//@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	//private List<OrderDetail> orderDetails;
	
	//@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "products")
	//@JsonIgnore
	//private List<ShoppingCart> shoppingCarts;


	public Product() {
		super();
		//this.name = "";
		//this.description = "";
		//this.price = 0;
		//this.categoryId = 0;
		//this.category = new Category();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	//public Category getCategory() {
	//	return category;
	//}

	//public void setCategory(Category category) {
	//	this.category = category;
	//}

	//public List<ProductImage> getProductImages() {
	//	return productImages;
	//}

	//public void setProductImages(List<ProductImage> productImages) {
	//	this.productImages = productImages;
	//}

	//public List<OrderDetail> getOrderDetails() {
	//	return orderDetails;
	//}

	//public void setOrderDetails(List<OrderDetail> orderDetails) {
	//	this.orderDetails = orderDetails;
	//}

	//public List<ShoppingCart> getShoppingCarts() {
	//	return shoppingCarts;
	//}

	//public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
	//	this.shoppingCarts = shoppingCarts;
	//}
}
