//RENAME THIS FILE TO "DoctorRepository", AND UPDATE PATHS, REST ALL SAME


package com.example.customerservice.repository;

import com.example.customerservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{
}
