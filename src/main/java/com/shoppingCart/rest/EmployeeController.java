package com.shoppingCart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoppingCart.dto.Employee;
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
        for(Employee e : employees) {
            if(e.isDeleted()){
                employees.remove(e);
            }
        }
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") final int id){
        Employee employee = employeeRepository.findById(id);
        if(employee.isDeleted()){
            return new ResponseEntity<Employee>(new Employee(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        employee = employeeRepository.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") final int id){
        employeeRepository.delete(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }

	@PostMapping("/login_employee")
	public ResponseEntity<Employee> login(@RequestBody Employee e){
		Employee employee = employeeRepository.login(e.getEmployeeCode(), e.getEmail(), e.getPassword());
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}
