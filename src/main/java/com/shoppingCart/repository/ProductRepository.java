package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Product;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findAll();
	Product findById(int id);
	Product save(Product product);

	@Query(value = "update Product set deleted = 1 where product_id = ?1", nativeQuery = true)
	boolean delete(int id);
}
