package com.cluster.springbootrestapi.springbootapi.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluster.springbootrestapi.springbootapi.modelTo.Phone;
import com.cluster.springbootrestapi.springbootapi.repository.EmployeeRepository;
import com.cluster.springbootrestapi.springbootapi.repository.PhoneRepository;

@Service
public class PhoneDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	PhoneRepository phoneRepository;
	
	/*to save an address*/
	
	public Phone save(Phone phones) {
		return phoneRepository.save(phones);
	}
	
	
	/* search all address*/
	
	public List<Phone> findAll(){
		return phoneRepository.findAll();
	}
	
	
	/*get an address by id
	public Optional<Phone> findOne(String id) {
		return phoneRepository.findById(id);
	}
	*/
	
	/*delete an address*/
	
	public void delete(Phone phones) {
		phoneRepository.delete(phones);
	}


	public Phone findById(String pid) {
		// TODO Auto-generated method stub
		return phoneRepository.findById(pid);
	}
}
