package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.ShoppingCart;
import com.shoppingCart.repository.ShoppingCartRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/shopping_carts")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<ShoppingCart>> listAllShoppingCarts(){
		List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
        for(ShoppingCart sc : shoppingCarts) {
            if(sc.isDeleted()){
                shoppingCarts.remove(sc);
            }
        }
		return new ResponseEntity<List<ShoppingCart>>(shoppingCarts, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable("id") final int id){
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id);
        if(shoppingCart.isDeleted()){
            return new ResponseEntity<ShoppingCart>(new ShoppingCart(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShoppingCart> createShoppingCart(@RequestBody ShoppingCart shoppingCart){
        shoppingCart = shoppingCartRepository.save(shoppingCart);
        return new ResponseEntity<ShoppingCart>(shoppingCart, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShoppingCart> deleteShoppingCart(@PathVariable("id") final int id){
        shoppingCartRepository.delete(id);
        return new ResponseEntity<ShoppingCart>(HttpStatus.NO_CONTENT);
    }
}
