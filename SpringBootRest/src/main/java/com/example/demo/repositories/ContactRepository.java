package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Contact;

@Repository
@Transactional
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	//executeQuery
	//JPQL - class and properties
	@Query("select c from Contact c where fname like :str")
	public List<Contact> getcontacts(String str);
	
	@Query(value = "select * from contacts where fnanme like :str",nativeQuery = true)
	public List<Contact> getcontacts1(String str);
	
	//executeUpdate
	@Modifying
	@Query("update Contact set email = ?2 where cid =?1")
	public int updateEmail(int cid,String email);
	
	/*
	@Procedure(name = "GET_CONTACTS")
	public List<Contact> call(); */
}
