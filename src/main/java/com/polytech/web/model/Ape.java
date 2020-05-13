package com.polytech.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ape database table.
 * 
 */
@Entity
@Table(name = "ape")
@NamedQuery(name="Ape.findAll", query="SELECT a FROM Ape a")
public class Ape implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy ="ape")
	private Company company;
	

	@Column(name="activity_desc")
	private String activityDesc;

	@Column(name="activity_name")
	private String activityName;

	private int code;

	
	public Ape(String activityDesc, String activityName, int code) {
		super();
		//this.id = id;
		this.activityDesc = activityDesc;
		this.activityName = activityName;
		this.code = code;
	}

	public Ape() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityDesc() {
		return this.activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}