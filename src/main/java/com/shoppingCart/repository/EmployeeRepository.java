/*package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Employee;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findAll();

	@Query(value = "sp_login_employee ?1, ?2, ?3", nativeQuery = true)
	Employee login(String employee_code, String email, String password);
}
*/