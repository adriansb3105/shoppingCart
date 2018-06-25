package com.shoppingCart.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Product")
public class Product implements Serializable{
	
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

	@Column(name="deleted")
	private boolean deleted;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

	//@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	//private Set<ProductImage> productImages;

	//@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.ALL}, mappedBy = "products")
	//@JsonIgnore
	//private Set<ShoppingCart> shoppingCarts;

	//@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private Inventory inventory;

	public Product() {
		super();
		this.category = new Category();
		//this.inventory = new Inventory();
	//	this.productImages = new HashSet<ProductImage>();
	//	this.shoppingCarts = new HashSet<ShoppingCart>();
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//public Set<ProductImage> getProductImages() {
	//	return productImages;
	//}

	//public void setProductImages(Set<ProductImage> productImages) {
	//	this.productImages = productImages;
	//}

	//public Set<ShoppingCart> getShoppingCarts() {
	//	return shoppingCarts;
	//}

	//public void setShoppingCarts(Set<ShoppingCart> shoppingCarts) {
	//	this.shoppingCarts = shoppingCarts;
	//}

	//public Inventory getInventory() {
	//	return inventory;
	//}

	//public void setInventory(Inventory inventory) {
	//	this.inventory = inventory;
	//}
}
