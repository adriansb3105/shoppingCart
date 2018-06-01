package com.shoppingCart.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="name")
	private String name;

	//@OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
	//private List<Product> products;


	public Category() {
		super();
	//	this.name = "";
	//	this.products = new ArrayList<Product>();
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//public List<Product> getProducts() {
	//	return products;
	//}

	//public void setProducts(List<Product> products) {
	//	this.products = products;
	//}

}
