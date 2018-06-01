/*package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCart.dto.Category;
import com.shoppingCart.dto.ProductImage;
import com.shoppingCart.repository.CategoryRepository;
import com.shoppingCart.repository.ProductImageRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product_images")
public class ProductImageController {

	@Autowired
	private ProductImageRepository productImageRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<ProductImage>> listAllProductImages(){
		List<ProductImage> productImages = productImageRepository.findAll();
		return new ResponseEntity<List<ProductImage>>(productImages, HttpStatus.OK);
	}
}
*/