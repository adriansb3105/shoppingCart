package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	List<Inventory> findAll();
}
