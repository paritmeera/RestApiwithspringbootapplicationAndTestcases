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
import com.cluster.springbootrestapi.springbootapi.DAO.AddressDao;
import com.cluster.springbootrestapi.springbootapi.modelTo.Address;


@RestController
@RequestMapping("/api")
public class AddressController {
	
	@Autowired
	AddressDao addressDAO;
	
	/* to save an address*/
	@PostMapping("/employees/address")
	public Address createaddress(@Valid @RequestBody Address address) {
		return addressDAO.save(address);
	}
	
	/*get all address*/
	@GetMapping("/employees/address")
	public List<Address> getAllAddress(){
		return addressDAO.findAll();
	}
	
	/*get address by addressId*/
	@GetMapping("/address/{id}")
	public ResponseEntity<String> getAddressById(@PathVariable(value="id") String aid){
		
		Address address=addressDAO.findById(aid);
		
		if(address==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(aid);
		
	}
	
	
	/*update an address by addressid*/
	@PutMapping("/employees/address/{id}")
	 public Address updateAddress(@PathVariable(value="id") String addressId,@Valid @RequestBody Address addressUpdated)
	 {
			Address address=addressDAO.findById(addressId);
			if(address==null) {
				return address;
			}
		 
					address.setAddressLineOne(addressUpdated.getAddressLineOne());
					address.setAddressLineTwo(addressUpdated.getAddressLineTwo());
					address.setPincode(addressUpdated.getPincode());
					return addressDAO.save(address);	
		
	}
	
	/*Delete an address*/
	@DeleteMapping("/address/{id}")
	public ResponseEntity<Address> deleteAddress(@PathVariable(value="id") String aid){
		
		Address address=addressDAO.findById(aid);
		if(address==null) {
			return ResponseEntity.notFound().build();
		}
		addressDAO.delete(address);
		
		return ResponseEntity.ok().build();
		
		
	}

}
