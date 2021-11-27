
package com.example.orderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Doctor {
@Id
private String id;
@Column
private String name;
@Column
private String patientName;
@Column
private String patientId;
@Column
private String patientDisease;

public Doctor(){}

    public Doctor(final String id, final String patientId, final String name,final String patientName, final String patientDisease ) {
        this.id = id;
        this.patientId = patientId;
        this.name = name;
        this.patientName=patientName;
        this.patientDisease=patientDisease;
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id=id;
        }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String id){
        this.patientId=id;
        }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
        }
    public String getPatientDisease(){
        return patientDisease;
    }

    public void setPatientDisease(String disease){
        this.patientDisease=disease;
        }

    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String name){
        this.patientName=name;
            }
    

}