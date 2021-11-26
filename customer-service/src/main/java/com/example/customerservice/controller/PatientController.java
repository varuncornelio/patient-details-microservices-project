package com.example.customerservice;
import org.springframework.stereotype.Controller;

import com.example.customerservice.model.Patient;
import  com.example.customerservice.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/patients")
@RestController
public class PatientController{
private final PatientService patientService;

public PatientController(PatientService patientService){
this.patientService=patientService;
}

@GetMapping("/getAllPatients")
public List<Patient> getAllPatients(){
return patientService.getAllPatients();
}

@GetMapping("/get/{patientID}")
public Patient getPatient(@PathVariable String patientID){
return patientService.getPatient(patientID);
}

@PostMapping("/createPatient")
public Patient createPatient(@RequestBody Patient patient){
return patientService.create(patient);
}

@PutMapping("/updatePatient/{id}")
public Patient updatePatient(@RequestBody Patient patient, @PathVariable String id){
return patientService.update(patient, id);
}

@DeleteMapping("/deletePatient/{id}")
public String deletePatient(@PathVariable String id){
patientService.delete(id);
return "Patient deleted";
}
}
