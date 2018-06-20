package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.Client;
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
	public ResponseEntity<Client> findClientById(@PathVariable("id") final int id){
		Client client = clientRepository.findById(id);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		client = clientRepository.save(client);
		return new ResponseEntity<Client>(client, HttpStatus.CREATED);
	}

	@PostMapping(value = "/login", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> login(@RequestBody Client client){
		Client c = this.clientRepository.login(client.getEmail(), client.getPassword());
		return new ResponseEntity<Client>(c, HttpStatus.OK);
	}
}
