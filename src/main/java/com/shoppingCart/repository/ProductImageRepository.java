package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.ProductImage;
import org.springframework.data.jpa.repository.Query;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>{
	List<ProductImage> findAll();
    ProductImage findById(int id);
    ProductImage save(ProductImage productImage);

    @Query(value = "update Product_Image set deleted = 1 where product_image_id = ?1", nativeQuery = true)
    boolean delete(int id);
}
