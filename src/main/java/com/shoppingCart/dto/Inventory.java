package com.shoppingCart.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private int inventoryId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", unique=true)
    private Product product;
	
	@Column(name="units")
	private int units;
	
}
