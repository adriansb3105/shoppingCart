package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.ProductImage;
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
        for(ProductImage pi : productImages) {
            if(pi.isDeleted()){
                productImages.remove(pi);
            }
        }
		return new ResponseEntity<List<ProductImage>>(productImages, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<ProductImage> getProductImageById(@PathVariable("id") final int id){
        ProductImage productImage = productImageRepository.findById(id);
        if(productImage.isDeleted()){
            return new ResponseEntity<ProductImage>(new ProductImage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductImage>(productImage, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductImage> createProductImage(@RequestBody ProductImage productImage){
        productImage = productImageRepository.save(productImage);
        return new ResponseEntity<ProductImage>(productImage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductImage> deleteProductImage(@PathVariable("id") final int id){
        productImageRepository.delete(id);
        return new ResponseEntity<ProductImage>(HttpStatus.NO_CONTENT);
    }
}
