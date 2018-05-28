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
import com.shoppingCart.repository.BillRepository;
import com.shoppingCart.repository.CategoryRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bills")
public class BillController {

	@Autowired
	private BillRepository billRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Bill>> listAllBills(){
		List<Bill> bills = billRepository.findAll();
		return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
	}
}
