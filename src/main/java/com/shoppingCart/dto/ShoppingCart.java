package com.shoppingCart.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Shopping_Cart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="shopping_cart_id")
	private int shoppingCartId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="dateCreated")
	private Date dateCreated;
	
	@Column(name="clientId")
	private int clientId;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="Shopping_Cart_Product",
	joinColumns = {@JoinColumn(name="shopping_cart_id")},
	inverseJoinColumns = {@JoinColumn(name="product_id")})
	private List<Product> products;

	
}
