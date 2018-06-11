package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Bill;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	List<Bill> findAll();
    Bill findById(int id);
    Bill save(Bill bill);

    @Query(value = "update Bill set deleted = 1 where bill_id = ?1", nativeQuery = true)
    boolean delete(int id);
}
