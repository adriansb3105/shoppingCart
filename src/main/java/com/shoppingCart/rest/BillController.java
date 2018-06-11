package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.Bill;
import com.shoppingCart.repository.BillRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bills")
public class BillController {

	@Autowired
	private BillRepository billRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Bill>> listAllBills(){
		List<Bill> bills = billRepository.findAll();
        for(Bill b : bills) {
            if(b.isDeleted()){
                bills.remove(b);
            }
        }
		return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") final int id){
        Bill bill = billRepository.findById(id);
        if(bill.isDeleted()){
            return new ResponseEntity<Bill>(new Bill(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Bill>(bill, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        bill = billRepository.save(bill);
        return new ResponseEntity<Bill>(bill, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bill> deleteBill(@PathVariable("id") final int id){
        billRepository.delete(id);
        return new ResponseEntity<Bill>(HttpStatus.NO_CONTENT);
    }
}
