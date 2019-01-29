package com.cluster.springbootrestapi.springbootapi.modelTo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.cluster.springbootrestapi.springbootapi.modelTo.Address;
import com.cluster.springbootrestapi.springbootapi.modelTo.Phone;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id @GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "e_id",nullable=false)
	private String id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String dob;
	

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name="e_id")
	private Set<Address> address= new HashSet<>();
	
	 public Set<Address> getAddress() {
			return address;
		}

		public void setAddress(Set<Address> address) {
			this.address = address;
		} 
	
	@OneToMany(cascade = CascadeType.ALL)
    @Column(name = "e_id")
	private Set<Phone> phones =new HashSet<>();
	 
   
    public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}
	
    public Employee() {
		
	}
	public Employee(String eid,String name,String dob, Set<Address> address, Set<Phone> phones) {
		super();
		this.id = eid;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.phones = phones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", phones=" + phones
				+ "]";
	}
    
	

}
