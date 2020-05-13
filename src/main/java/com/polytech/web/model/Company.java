package com.polytech.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name = "company")
public class Company {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "Nom")
	private String nom;

	@Column(name = "RCS")
	private int rcs;

	@Column(name = "SIREN")
	private int siren;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id_address") //(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Address address; // instance of the class address

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id_ape")// (cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Ape ape; // instance of class ape


	public Company(String nom, int rcs, int siren, Address address, Ape ape) {
		super();
		this.nom = nom;
		this.rcs = rcs;
		this.siren = siren;
		this.address = address;
		this.ape = ape;

	}

	public Company() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getRcs() {
		return this.rcs;
	}

	public void setRcs(int rcs) {
		this.rcs = rcs;
	}

	public int getSiren() {
		return this.siren;
	}

	public void setSiren(int siren) {
		this.siren = siren;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Ape getApe() {
		return ape;
	}

	public void setApe(Ape ape) {
		this.ape = ape;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + "  " + this.nom + "  " + this.rcs + "  " + this.siren + " "+
				this.address.getLine1() + " " + this.address.getLine2() + "  " + this.address.getCity();
		
	}

}