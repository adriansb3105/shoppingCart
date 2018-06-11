package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.ShoppingCart;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
	List<ShoppingCart> findAll();
    ShoppingCart findById(int id);
    ShoppingCart save(ShoppingCart shoppingCart);

    @Query(value = "update Shopping_Cart set deleted = 1 where shopping_cart_id = ?1", nativeQuery = true)
    boolean delete(int id);
}
