package com.example.demo.entities;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="patient")
public class Patient {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	
	@Column
	String fname;
	
	
	@Column
	String lname;
	
	
	@Column
	String address;
	
	@Column
	String contact;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column
	Date birthdate;
	
	public Patient(String fname, String lname, String address, String contact, Date birthdate, Doctor doctor) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.contact = contact;
		this.birthdate = birthdate;
		this.doctor = doctor;
	}

	@JsonIgnoreProperties("doctors")
	@ManyToOne
	@JoinColumn(name="doctor_id")
	Doctor doctor;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Patient(int pid, String fname, String lname, String address, String contact, Date birthdate, Doctor doctor) {
		super();
		this.pid = pid;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.contact = contact;
		this.birthdate = birthdate;
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", fname=" + fname + ", lname=" + lname + ", address=" + address + ", contact="
				+ contact + ", birthdate=" + birthdate + ", doctor=" + doctor + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
	
	


	

}
