


package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepo;

@Service
public class PatientService {

	@Autowired
	PatientRepo prepo;
	
	
	public Patient getone(int pid)
	{
		Patient c = null;
		Optional<Patient> op =  prepo.findById(pid);
		try
		{
			c = op.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	public Patient save(Patient ct)
	{
		return prepo.save(ct);
	}
	
}
