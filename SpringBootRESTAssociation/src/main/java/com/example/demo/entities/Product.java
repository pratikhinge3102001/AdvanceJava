package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int p_id;
	
	@Column
	String p_name;
	
	@Column
	String p_description;
	
	@Column
	float p_price;
	
	@JsonIgnoreProperties("products")
	@ManyToOne
	@JoinColumn(name="cat_id")
	Category category;


	public Product(int p_id, String p_name, String p_decsription, float p_price, Category category) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_description = p_decsription;
		this.p_price = p_price;
		this.category = category;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getP_id() {
		return p_id;
	}


	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getP_description() {
		return p_description;
	}


	public void setP_description(String p_decsription) {
		this.p_description = p_decsription;
	}


	public float getP_price() {
		return p_price;
	}


	public void setP_price(float p_price) {
		this.p_price = p_price;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	

}
