package com.shoppingCart.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Inventory")
public class Inventory implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private int inventoryId;
	
	@Column(name="units")
	private int units;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "product_id")
    private Product product;

    @Column(name="deleted")
    private boolean deleted;

	public Inventory() {
		this.product = new Product();
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
