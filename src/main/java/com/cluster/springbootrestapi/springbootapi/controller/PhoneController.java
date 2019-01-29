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
import com.cluster.springbootrestapi.springbootapi.DAO.PhoneDao;
import com.cluster.springbootrestapi.springbootapi.modelTo.Phone;


@RestController
@RequestMapping("/api")
public class PhoneController {

	@Autowired
	PhoneDao phoneDAO;
	
	/* to save an phones*/
	@PostMapping("/employees/phones")
	public Phone createphones(@Valid @RequestBody Phone phone) {
		return phoneDAO.save(phone);
	}
	
	/*get all phones*/
	@GetMapping("/employees/phones")
	public List<Phone> getAllPhones(){
		return phoneDAO.findAll();
	}
	
	/*get address by phoneId*/
	@GetMapping("/employees/{id}/phones/{id}")
	public ResponseEntity<String> getPhoneById(@PathVariable(value="id") String pid){
		
		Phone phone=phoneDAO.findById(pid);
		
		if(phone==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pid);
		
	}
	
	
	/*update an phones by phoneid*/
	@PutMapping("/employees/phones/{id}")
	 public Phone updatePhones(@PathVariable(value="id") String phoneId,@Valid @RequestBody Phone phoneUpdated)
	 {
			Phone phone=phoneDAO.findById(phoneId);
			if(phone==null) {
				return phone;
			}
		 
			phone.setPhoneType(phoneUpdated.getPhoneType());
        	phone.setPhoneNumber(phoneUpdated.getPhoneNumber());
					return phoneDAO.save(phone);
			
		
		
	}
	
	/*Delete an phones*/
	@DeleteMapping("/phones/{id}")
	public ResponseEntity<Phone> deletePhone(@PathVariable(value="id") String pid){
		
		Phone ph=phoneDAO.findById(pid);
		if(ph==null) {
			return ResponseEntity.notFound().build();
		}
		phoneDAO.delete(ph);
		
		return ResponseEntity.ok().build();
		
		
	}
}
