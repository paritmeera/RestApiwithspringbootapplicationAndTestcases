package com.cluster.springbootrestapi.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cluster.springbootrestapi.springbootapi.modelTo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findById(String empid);

	

	

}
