package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.OrderDetail;
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
        for(OrderDetail od : orderDetails) {
            if(od.isDeleted()){
                orderDetails.remove(od);
            }
        }
        return new ResponseEntity<List<OrderDetail>>(orderDetails, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable("id") final int id){
        OrderDetail orderDetail = orderDetailRepository.findById(id);
        if(orderDetail.isDeleted()){
            return new ResponseEntity<OrderDetail>(new OrderDetail(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderDetail>(orderDetail, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail){
        orderDetail = orderDetailRepository.save(orderDetail);
        return new ResponseEntity<OrderDetail>(orderDetail, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDetail> deleteOrderDetail(@PathVariable("id") final int id){
        orderDetailRepository.delete(id);
        return new ResponseEntity<OrderDetail>(HttpStatus.NO_CONTENT);
    }
}
