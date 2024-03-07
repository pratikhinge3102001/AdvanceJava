package com.example.demo.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Doctor;



@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}