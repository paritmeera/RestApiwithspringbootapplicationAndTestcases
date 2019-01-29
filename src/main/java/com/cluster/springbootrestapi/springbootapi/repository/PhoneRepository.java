package com.cluster.springbootrestapi.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cluster.springbootrestapi.springbootapi.modelTo.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>{
	Phone findById(String eId);	

}
