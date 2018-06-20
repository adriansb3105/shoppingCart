package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Client;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	List<Client> findAll();
	Client save(Client client);
	Client findById(int id);

	@Query(value = "sp_login_client ?1, ?2", nativeQuery = true)
	Client login(String email, String password);

	//@Query(value = "select * from Client where email = ?1", nativeQuery = true)
	//Client findByEmail(String email);
}
