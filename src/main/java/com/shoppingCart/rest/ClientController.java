package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.Bill;
import com.shoppingCart.dto.Category;
import com.shoppingCart.dto.Client;
import com.shoppingCart.repository.BillRepository;
import com.shoppingCart.repository.CategoryRepository;
import com.shoppingCart.repository.ClientRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Client>> listAllClients(){
		List<Client> clients = clientRepository.findAll();
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> findClientById(int id){
		Client client = clientRepository.findById(id);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> createClient(@RequestBody final Client client){
		clientRepository.save(client);
		return new ResponseEntity<Client>(client, HttpStatus.CREATED);
	}

	@GetMapping("login_user/{email}/{password}")
	public ResponseEntity<Client> login(String email, String password){
		Client client = clientRepository.login(email, password);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
}
