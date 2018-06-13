package com.shoppingCart.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Shopping_Cart")
public class ShoppingCart implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="shopping_cart_id")
	private int shoppingCartId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="date_created")
	private Date dateCreated;

    @Column(name="deleted")
    private boolean deleted;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="Shopping_Cart_Product",
	joinColumns = {@JoinColumn(name="shopping_cart_id")},
	inverseJoinColumns = {@JoinColumn(name="product_id")})
	private Set<Product> products;


	public ShoppingCart() {
		this.dateCreated = new Date();
		this.client = new Client();
		this.products = new HashSet<>();
	}

	public int getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
