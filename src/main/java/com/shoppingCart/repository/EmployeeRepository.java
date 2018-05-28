package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findAll();
}
