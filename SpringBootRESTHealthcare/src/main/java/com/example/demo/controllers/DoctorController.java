package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Doctor;

import com.example.demo.services.DoctorService;


@RestController
public class DoctorController {

	@Autowired
	DoctorService cservice;
	
	@GetMapping("/getDoctors")
	public List<Doctor> getAll()
	{
		return cservice.getAll();
	}
	
	
	
	
	
	
}
