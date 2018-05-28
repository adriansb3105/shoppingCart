package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	List<Client> findAll();
}
