package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Inventory;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	List<Inventory> findAll();
    Inventory findById(int id);
    Inventory save(Inventory inventory);

    @Query(value = "update Inventory set units = units - ?1 where  product_id = ?2", nativeQuery = true)
    boolean buyUnits(int quantity, int id);

    @Query(value = "update Inventory set units = units + ?1 where  product_id = ?2", nativeQuery = true)
    boolean addUnits(int quantity, int id);

    @Query(value = "update Inventory set deleted = 1 where product_id = ?1", nativeQuery = true)
    boolean delete(int id);
}
