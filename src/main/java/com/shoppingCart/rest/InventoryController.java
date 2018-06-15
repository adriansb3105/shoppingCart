package com.shoppingCart.rest;

import java.util.List;

import com.shoppingCart.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.Inventory;
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
        for(Inventory i : inventories) {
            if(i.isDeleted()){
                inventories.remove(i);
            }
        }
		return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") final int id){
        Inventory inventory = inventoryRepository.findById(id);
        if(inventory.isDeleted()){
            return new ResponseEntity<Inventory>(new Inventory(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
        inventory = inventoryRepository.save(inventory);
        return new ResponseEntity<Inventory>(inventory, HttpStatus.CREATED);
    }

    @PostMapping(value = "/buy", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> buyUnits(@PathVariable("quantity") final int quantity, @RequestBody Product product){
        inventoryRepository.buyUnits(quantity, product.getProductId());
        return new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/add", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addUnits(@PathVariable("quantity") final int quantity, @RequestBody Product product){
        inventoryRepository.addUnits(quantity, product.getProductId());
        return new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Inventory> deleteInventory(@PathVariable("id") final int id){
        inventoryRepository.delete(id);
        return new ResponseEntity<Inventory>(HttpStatus.NO_CONTENT);
    }
}
