//RENAME THIS FILE TO "DoctorRepository", AND UPDATE PATHS, REST ALL SAME


package com.example.orderservice.repository;

import com.example.orderservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String>{
}