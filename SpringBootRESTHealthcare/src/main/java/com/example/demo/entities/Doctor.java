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
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int doctor_id;
	
	@Column
	String name;	
	
	@Column
	String degree;
	
	@Column
	String specialization;
	
	@Column
	String experience;
	
	@JsonIgnoreProperties("doctor")
	@OneToMany(mappedBy="doctor" ,cascade = CascadeType.ALL)
	Set<Patient> patients;
	
	

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Doctor(String name, String degree, String specialization, String experience) {
		super();
		this.name = name;
		this.degree = degree;
		this.specialization = specialization;
		this.experience = experience;
		
	}
	
	



	public Doctor(String name, String degree, String specialization, String experience, Set<Patient> patients) {
		super();
		this.name = name;
		this.degree = degree;
		this.specialization = specialization;
		this.experience = experience;
		for(Patient p :patients)
			p.setDoctor(this);
		this.patients = patients;
	}



	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}
	
	
	
	
	
	
	

	


	

	
	
	
	

}
