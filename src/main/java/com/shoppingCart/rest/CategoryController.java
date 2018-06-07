package com.shoppingCart.rest;

import java.util.List;

import com.shoppingCart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.Category;
import com.shoppingCart.repository.CategoryRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/")
	public ResponseEntity<List<Category>> listAllCategories(){
		List<Category> categories = categoryRepository.findAll();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") final int id){
		Category category = categoryRepository.findById(id);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> createCategory(@RequestBody Category category){
		category = categoryRepository.save(category);
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deleteProduct(@PathVariable("id") final int id){
		categoryRepository.deleteById(id);
		return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
	}
}
