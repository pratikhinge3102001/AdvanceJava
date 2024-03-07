package com.example.demo.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int c_id;
	
	@Column
	String c_name;	
	
	@Column
	String c_description;
	
	@JsonIgnoreProperties("category")
	@OneToMany(mappedBy="category" ,cascade = CascadeType.ALL)
	Set<Product> products;
	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(int c_id, String c_name, String c_description) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_description = c_description;
	}


	public Category(int c_id, String c_name, String c_description, Set<Product> products) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_description = c_description;
		for(Product p :products)
			p.setCategory(this);
		this.products = products;
	}


	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


	public String getC_description() {
		return c_description;
	}


	public void setC_description(String c_description) {
		this.c_description = c_description;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		for(Product p :products)
			p.setCategory(this);
		this.products = products;
	}

	
	
	

}
