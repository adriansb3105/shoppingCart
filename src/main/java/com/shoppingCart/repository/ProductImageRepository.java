package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>{
	List<ProductImage> findAll();
    ProductImage findById(int id);
    ProductImage save(ProductImage productImage);
    void deleteById(int id);
}
