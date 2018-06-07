package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.Product;
import com.shoppingCart.repository.ProductRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public ResponseEntity<List<Product>> listAllProducts(){
		List<Product> products = productRepository.findAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") final int id){
        Product product = productRepository.findById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        product = productRepository.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") final int id){
        productRepository.deleteById(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
}
