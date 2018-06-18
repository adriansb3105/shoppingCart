package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.Client;
import com.shoppingCart.repository.ClientRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public ClientController(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

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

	@GetMapping("/login_user/{email}")
	public ResponseEntity<Client> login(@PathVariable("email") final String email){
		Client client = clientRepository.login(email);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody Client client) {
		client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
		clientRepository.save(client);
	}
}
