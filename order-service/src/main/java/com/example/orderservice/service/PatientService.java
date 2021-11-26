// MAIN CHANGES HERE, RENAME PATIENTS TO DOCTOS, AND ALSO IF YOU ADDED ANY NEW COLUMNS OR ATTRIBUTES TO DOCTOR MODEL,BE SURE TO ADD STUFF FOR THAT, NOT JUST HERE, BUT EVEN IN CONTROLLER FILE.
// IN UPDATE FUNCTION, USE HTTPURL LIBRARY, TO SEND A MESSAGE TO localhost:3081/patients/get/{id}, PASS THE PATIENT ID TO GET PATIENT DETAILS
//USE THE RESPONSE TO SET PATIENT DETAILS FOR THE DOCTOR, LIKE PATIENT NAME AND DISEASE.
// DO ANY OTHER RELEVANT CHANGES, LIKE UPDATING PACKAGE AND IMPORT PATHS WHEREVER NEEDED.
//ONCE DONE, RENAME FILE to "DoctorService.java" 


package com.example.customerservice.service;

import com.example.customerservice.model.Patient;
import com.example.customerservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService{

private final PatientRepository patientRepository;

public PatientService(PatientRepository patientRepository){
this.patientRepository=patientRepository;
}

public List<Patient> getAllPatients(){
return patientRepository.findAll();
}

public Patient getPatient(String id){
return patientRepository.findById(id).orElse(null);
}

public Patient create(Patient p){
return patientRepository.save(p);
}

public void delete(String id){
patientRepository.deleteById(id);
}

public Patient update(Patient p, String id){
Patient p1= patientRepository.findById(id).get();
p1.setName(p.getName());
p1.setDisease(p.getDisease());
patientRepository.save(p1);
return p1;
}

public void deleteAll(){
patientRepository.deleteAll();
}
}
