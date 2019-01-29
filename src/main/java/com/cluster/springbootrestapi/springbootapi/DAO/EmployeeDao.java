package com.cluster.springbootrestapi.springbootapi.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluster.springbootrestapi.springbootapi.modelTo.Employee;
import com.cluster.springbootrestapi.springbootapi.repository.EmployeeRepository;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	/*to save an employee*/
	
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	/* search all employees*/
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	
	/*get an employee by id*/
	/*public Employee findOne(String empid) {
		return employeeRepository.findById(empid);
	}*/
	
	
	/*delete an employee*/
	
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}


	public Employee findById(String empid) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empid);
	}


	
}
