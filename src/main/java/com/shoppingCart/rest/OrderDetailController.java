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
import com.shoppingCart.dto.OrderDetail;
import com.shoppingCart.repository.CategoryRepository;
import com.shoppingCart.repository.OrderDetailRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order_details")
public class OrderDetailController {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<OrderDetail>> listAllOrderDetails(){
		List<OrderDetail> orderDetails = orderDetailRepository.findAll();
		return new ResponseEntity<List<OrderDetail>>(orderDetails, HttpStatus.OK);
	}
}
*/