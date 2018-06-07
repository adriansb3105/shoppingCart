package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findAll();
	Product findById(int id);
	Product save(Product product);
	void deleteById(int id);
}
