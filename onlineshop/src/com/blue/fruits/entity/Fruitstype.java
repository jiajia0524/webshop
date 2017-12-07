package com.blue.fruits.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fruitstype")
public class Fruitstype {
	
	private int fruitstype_id;
	private String fruitstype_name;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFruitstype_id() {
		return fruitstype_id;
	}
	public void setFruitstype_id(int fruitstype_id) {
		this.fruitstype_id = fruitstype_id;
	}
	public String getFruitstype_name() {
		return fruitstype_name;
	}
	public void setFruitstype_name(String fruitstype_name) {
		this.fruitstype_name = fruitstype_name;
	}

}
