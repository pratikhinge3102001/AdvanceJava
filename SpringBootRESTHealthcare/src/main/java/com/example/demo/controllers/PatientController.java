

package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Patient;

import com.example.demo.services.PatientService;

@RestController
public class PatientController {

	@Autowired
	PatientService pservice;
	
	@PostMapping("/savePatient")
	public Patient save(@RequestBody Patient ct)
	{
		return pservice.save(ct);
	}
	
	
}

