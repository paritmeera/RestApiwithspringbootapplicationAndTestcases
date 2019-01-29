package com.cluster.springbootrestapi.springbootapi.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cluster.springbootrestapi.springbootapi.DAO.EmployeeDao;
import com.cluster.springbootrestapi.springbootapi.modelTo.Employee;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDAO;
	
	/* to save an employee*/
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employ) {
		return employeeDAO.save(employ);
	}
	
	/*get all employees*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	/*get employee by empid*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") String empid){
		
		Employee employ=employeeDAO.findById(empid);
		
		if(employ==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(employ);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") String empid,@Valid @RequestBody Employee empUpdated){
		
		Employee employ=employeeDAO.findById(empid);
		if(employ==null) {
			return ResponseEntity.notFound().build();
		}
		
		employ.setName(empUpdated.getName());
		employ.setDob(empUpdated.getDob());
		employ.setAddress(empUpdated.getAddress());
    	employ.setPhones(empUpdated.getPhones());
    
    	Employee updateEmployee=employeeDAO.save(employ);
		return ResponseEntity.ok().body(updateEmployee);
		
		
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") String empid){
		
		Employee employ=employeeDAO.findById(empid);
		if(employ==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(employ);
		
		return ResponseEntity.ok().build();
		
		
	}
	


}
