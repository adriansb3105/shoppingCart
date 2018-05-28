package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCart.dto.Category;
import com.shoppingCart.dto.Inventory;
import com.shoppingCart.repository.CategoryRepository;
import com.shoppingCart.repository.InventoryRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Inventory>> listAllInventories(){
		List<Inventory> inventories = inventoryRepository.findAll();
		return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);
	}
}
