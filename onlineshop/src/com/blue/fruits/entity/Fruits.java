package com.blue.fruits.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="fruits")
public class Fruits {
	
	private int fruits_id;
	private String fruits_name;
	private String fruits_count;
	private String fruits_describe;
	private double fruits_presentprice;
	private double fruits_originalprice;
	private Fruitstype fruitstype_id;
	private String fruits_producingplace;
	private String fruits_image;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getFruits_id() {
		return fruits_id;
	}
	public void setFruits_id(int fruits_id) {
		this.fruits_id = fruits_id;
	}
	public String getFruits_name() {
		return fruits_name;
	}
	public void setFruits_name(String fruits_name) {
		this.fruits_name = fruits_name;
	}
	public String getFruits_count() {
		return fruits_count;
	}
	public void setFruits_count(String fruits_count) {
		this.fruits_count = fruits_count;
	}
	public String getFruits_describe() {
		return fruits_describe;
	}
	public void setFruits_describe(String fruits_describe) {
		this.fruits_describe = fruits_describe;
	}
	public double getFruits_presentprice() {
		return fruits_presentprice;
	}
	public void setFruits_presentprice(double fruits_presentprice) {
		this.fruits_presentprice = fruits_presentprice;
	}
	public double getFruits_originalprice() {
		return fruits_originalprice;
	}
	public void setFruits_originalprice(double fruits_originalprice) {
		this.fruits_originalprice = fruits_originalprice;
	}
	@ManyToOne
	@JoinColumn(name="fruitstype_id")
	public Fruitstype getFruitstype_id() {
		return fruitstype_id;
	}
	public void setFruitstype_id(Fruitstype fruitstype_id) {
		this.fruitstype_id = fruitstype_id;
	}
	public String getFruits_image() {
		return fruits_image;
	}
	public void setFruits_image(String fruits_image) {
		this.fruits_image = fruits_image;
	}
	public String getFruits_producingplace() {
		return fruits_producingplace;
	}
	public void setFruits_producingplace(String fruits_producingplace) {
		this.fruits_producingplace = fruits_producingplace;
	}
	

}
