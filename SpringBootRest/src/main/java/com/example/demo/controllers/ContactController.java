package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Contact;
import com.example.demo.services.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService cservice;
	
	@GetMapping("/getall")
	public List<Contact> getAll()
	{
		return cservice.getall();
	}
	
	//http://localhost:8080/getcontact?cid=1
	@GetMapping("/getcontact")
	public Contact getOne(@RequestParam("cid")int cid)
	{
		return cservice.getOne(cid);
	}
	
	//http://localhost:8080/getone/6
	@GetMapping("/getone/{cid}")
	public Contact getOne1(@PathVariable("cid") int cid) 
	{
		return cservice.getOne(cid);
	}
	
	
	@PostMapping("/savecontact")
	public Contact save(@RequestBody Contact ct)
	{
		return cservice.save(ct);
	}
	
	@GetMapping("/getcontacts")
	public List<Contact> getContacts(@RequestParam("start") String str)
	{
		return cservice.getContact(str+"%");
	}
	
	@GetMapping("/update_email")
	public int updateEmail(@RequestParam("cid") int cid,@RequestParam("mailid") String email)
	{
		return cservice.update(cid, email);	
	}
	
	
}
