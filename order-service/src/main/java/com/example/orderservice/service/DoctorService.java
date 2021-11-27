// MAIN CHANGES HERE, RENAME PATIENTS TO DOCTOS, AND ALSO IF YOU ADDED ANY NEW COLUMNS OR ATTRIBUTES TO DOCTOR MODEL,BE SURE TO ADD STUFF FOR THAT, NOT JUST HERE, BUT EVEN IN CONTROLLER FILE.
// IN UPDATE FUNCTION, USE HTTPURL LIBRARY, TO SEND A MESSAGE TO localhost:3081/doctors/get/{id}, PASS THE PATIENT ID TO GET PATIENT DETAILS
//USE THE RESPONSE TO SET PATIENT DETAILS FOR THE DOCTOR, LIKE PATIENT NAME AND DISEASE.
// DO ANY OTHER RELEVANT CHANGES, LIKE UPDATING PACKAGE AND IMPORT PATHS WHEREVER NEEDED.
//ONCE DONE, RENAME FILE to "DoctorService.java" 


package com.example.orderservice.service;

import com.example.orderservice.model.Doctor;
import com.example.orderservice.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.net.*;
import java.util.List;
import java.net.http.*;
import org.json.*;
import java.io.*;

@Service
public class DoctorService  {

private final DoctorRepository doctorRepository;

public DoctorService(DoctorRepository doctorRepository){
this.doctorRepository=doctorRepository;
}

public List<Doctor> getAllDoctors(){
return doctorRepository.findAll();
}

public Doctor getDoctor(String id){
return doctorRepository.findById(id).orElse(null);
}

public Doctor create(Doctor p){
return doctorRepository.save(p);
}

public void delete(String id){
doctorRepository.deleteById(id);
}

public Doctor update(String pid, String id){
Doctor p1= doctorRepository.findById(id).get();
System.out.println(pid+"received");
String USER_AGENT = "Mozilla/5.0";
String GET_URL = "http://localhost:3001/patients/get/"+pid;
        try{

                        URL obj = new URL(GET_URL);
                        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                        con.setRequestMethod("GET");
                        con.setRequestProperty("User-Agent", USER_AGENT);
                        int responseCode = con.getResponseCode();
                        System.out.println("GET Response Code :: " + responseCode);
                        if (responseCode == HttpURLConnection.HTTP_OK) { // success
                                BufferedReader in = new BufferedReader(new InputStreamReader(
                                                con.getInputStream()));
                                String inputLine;
                                StringBuffer response = new StringBuffer();
        
                                while ((inputLine = in.readLine()) != null) {
                                        response.append(inputLine);
                                }
                                in.close();
        
                                // print result
                                System.out.println(response.toString());

                                JSONObject jsonObj = new JSONObject(response.toString());
                                System.out.println(jsonObj);
                                String pname = jsonObj.getString("name");
                                String dis = jsonObj.getString("disease");
                                p1.setPatientName(pname);
                                p1.setPatientDisease(dis);
                                p1.setPatientId(pid);
                                doctorRepository.save(p1);
                        } else {
                                System.out.println("GET request not worked");
                        }
                //HttpResponse<String> response = client.send(request,
                //HttpResponse.BodyHandlers.ofString());
                
        
        

        
        
        
        }
        catch(Exception e){
                e.printStackTrace();
        }

        return p1;
}

public void deleteAll(){
doctorRepository.deleteAll();
}
}
