package com.shoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingCart.dto.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findAll();

	Employee findById(int id);
	Employee save(Employee employee);

	@Query(value = "sp_login_employee ?1, ?2, ?3", nativeQuery = true)
	Employee login(String employee_code, String email, String password);

	@Query(value = "update Employee set deleted = 1 where employee_id = ?1", nativeQuery = true)
	@Modifying
	@Transactional
	void delete(int id);
}
