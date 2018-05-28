package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
