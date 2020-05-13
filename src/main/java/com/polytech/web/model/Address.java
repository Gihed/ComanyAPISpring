package com.polytech.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name = "address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String city;

	private String country;
	

	@Column(name="line_1")
	private String line1;

	@Column(name="line_2")
	private String line2;

	@Column(name="name_address")
	private String nameAddress;

	@Column(name="zip_code")
	private String zipCode;
	
	@OneToOne(mappedBy ="address")
	private Company company;

	public Address(String city, String country, String line1, String line2, String nameAddress,
			String zipCode) {
		super();
		//this.id = id;
		this.city = city;
		this.country = country;
		this.line1 = line1;
		this.line2 = line2;
		this.nameAddress = nameAddress;
		this.zipCode = zipCode;
	}

	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLine1() {
		return this.line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return this.line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getNameAddress() {
		return this.nameAddress;
	}

	public void setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}