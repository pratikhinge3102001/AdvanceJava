package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Contact;
import com.example.demo.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository crepo;
	
	public List<Contact> getall()
	{		
		return crepo.findAll();
	}
	
	public Contact getOne(int cid)
	{
		 Contact ct=null; 
		 Optional<Contact> opt_ct = crepo.findById(cid);
		 try
		 {
			 ct = opt_ct.get();
		 }
		 catch(Exception e)
		 {
			 ct=null;
		 }
		 return ct;		 
	}
	
	public Contact save(Contact ct)
	{
		return crepo.save(ct);
	}	
	
	public List<Contact> getContact(String str)
	{
		return crepo.getcontacts(str);
	}
	
	public int update(int cid,String email)
	{
		return crepo.updateEmail(cid, email);
	}
	
	
	
}
