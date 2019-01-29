package com.cluster.springbootrestapi.springbootapi.modelTo;

import java.io.Serializable;


//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "address")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements Serializable{
	
private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "a_id",nullable=false)
	private String id;
	
	@NotNull
	private String addressLineOne;
	
	@NotNull
	private String addressLineTwo;
	
	@NotNull
	private String pincode;

	
/*	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "EMPLOYEEADDRESS", joinColumns = { @JoinColumn(name = "a_id") }, inverseJoinColumns = { @JoinColumn(name = "e_id")})
	@JoinColumn(name="e_id")
	@JsonIgnore
    private Employee employee;
    */

	public Address() {
		
	}
	
	public Address(String id, String addressLineOne,String addressLineTwo,  String pincode,Employee employee) {
		super();
		this.id = id;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.pincode = pincode;
	//	this.employee = employee;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/*public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/
	
	
}
