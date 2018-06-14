package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	List<Category> findAll();
	Category findById(int id);
	Category save(Category category);

	@Query(value = "update Category set deleted = 1 where category_id = ?1")
	@Modifying
	@Transactional
	void delete(int id);
}
