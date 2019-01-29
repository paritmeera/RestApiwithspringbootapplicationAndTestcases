package com.cluster.springbootrestapi.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cluster.springbootrestapi.springbootapi.modelTo.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
	Address findById(String id);


}
