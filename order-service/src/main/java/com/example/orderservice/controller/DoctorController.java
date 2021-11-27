//USE PATIENT CONTROLLER AS REFERENCE AND UPDATE THIS FILE.
// NOTHING MAJOR TO BE DONE OTHER THAN NAME CHANGING
//DO NOT FORGET TO UPDATE THE PACKAGE AND IMPORT PATHS BELOW PROPERLY, EVEN THOUGH WE ARE DOING FOR DOCTORS, THE PATH WILL BE THROUGH "orderservice", SO MIND THAT.
//ONCE DONE ALL CHANGES, RENAME FILE TO "DoctorController.java"


package com.example.orderservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.orderservice.model.Doctor;
import  com.example.orderservice.service.DoctorService;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/doctors")
@RestController
public class DoctorController{
private final DoctorService doctorService;

public DoctorController(DoctorService doctorService){
this.doctorService=doctorService;
}

@GetMapping("/getAllDoctors")
public List<Doctor> getAllDoctors(){
return doctorService.getAllDoctors();
}

@GetMapping("/get/{doctorID}")
public Doctor getDoctor(@PathVariable String doctorID){
return doctorService.getDoctor(doctorID);
}

@PostMapping("/createDoctor")
public Doctor createDoctor(@RequestBody Doctor doctor){
return doctorService.create(doctor);
}

@PutMapping("/updateDoctor/{id}")
public Doctor updateDoctor(@RequestBody String pid, @PathVariable String id){
System.out.println(pid+"sent");
return doctorService.update(pid, id);
}

@DeleteMapping("/deleteDoctor/{id}")
public String deleteDoctor(@PathVariable String id){
doctorService.delete(id);
return "Doctor deleted";
}
}
