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
import com.shoppingCart.dto.Client;
import com.shoppingCart.dto.Employee;
import com.shoppingCart.repository.BillRepository;
import com.shoppingCart.repository.CategoryRepository;
import com.shoppingCart.repository.ClientRepository;
import com.shoppingCart.repository.EmployeeRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public ResponseEntity<List<Employee>> listAllEmployees(){
		List<Employee> employees = employeeRepository.findAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
}
