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
@Table(name = "phones")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phone implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="p_id",nullable=false)
	private String id;
	
	@NotNull
	private String phoneType;
	
	@NotNull
	private String phoneNumber;

	
/*	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "EMPLOYEEPHONE", joinColumns = { @JoinColumn(name = "p_id") }, inverseJoinColumns = { @JoinColumn(name = "e_id") })
    @JoinColumn(name = "e_id")
    private Employee employee;*/

	public Phone() {
		
	}
	
	public Phone(String id,String phoneType,String phoneNumber, Employee employee) {
		super();
		this.id = id;
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
	//	this.employee = employee;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/*public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/


}
