package com.cluster.springbootrestapi.springbootapi.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluster.springbootrestapi.springbootapi.modelTo.Address;
import com.cluster.springbootrestapi.springbootapi.repository.AddressRepository;
import com.cluster.springbootrestapi.springbootapi.repository.EmployeeRepository;

@Service
public class AddressDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	/*to save an address*/
	
	public Address save(Address address) {
		return addressRepository.save(address);
	}
	
	
	/* search all address*/
	
	public List<Address> findAll(){
		return addressRepository.findAll();
	}
	
	
	/*get an address by id
	public Address findOne(String aId) {
		return addressRepository.findById(aId);
	}
	*/
	
	/*delete an address*/
	
	public void delete(Address address) {
		addressRepository.delete(address);
	}


	public Address findById(String aid) {
		return addressRepository.findById(aid);
	}


	


}
