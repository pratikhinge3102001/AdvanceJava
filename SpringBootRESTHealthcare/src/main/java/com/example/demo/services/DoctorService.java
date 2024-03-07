

package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Doctor;
import com.example.demo.repositories.DoctorRepo;

@Service
public class DoctorService {

	@Autowired
	DoctorRepo crepo;
	
	public List<Doctor> getAll()
	{
		return crepo.findAll();
	}
	
	
	
	
	
}

