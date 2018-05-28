package com.shoppingCart.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Product_Image")
public class ProductImage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_image_id")
	private int productImageId;
	
	@Column(name="url")
	private String url;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;

	public ProductImage() {
		super();
		this.productImageId = 0;
		this.url = "";
		this.product = new Product();
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
