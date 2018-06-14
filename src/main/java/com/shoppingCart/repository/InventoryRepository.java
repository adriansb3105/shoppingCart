package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Inventory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	List<Inventory> findAll();
    Inventory findById(int id);
    Inventory save(Inventory inventory);

    @Query(value = "update Inventory set units = units - ?1 where  product_id = ?2", nativeQuery = true)
    @Modifying
    @Transactional
    void buyUnits(int quantity, int id);

    @Query(value = "update Inventory set units = units + ?1 where  product_id = ?2", nativeQuery = true)
    @Modifying
    @Transactional
    void addUnits(int quantity, int id);

    @Query(value = "update Inventory set deleted = 1 where product_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void delete(int id);
}
