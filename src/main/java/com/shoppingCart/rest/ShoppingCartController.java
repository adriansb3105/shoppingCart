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
import com.shoppingCart.dto.ShoppingCart;
import com.shoppingCart.repository.CategoryRepository;
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
		return new ResponseEntity<List<ShoppingCart>>(shoppingCarts, HttpStatus.OK);
	}
}
