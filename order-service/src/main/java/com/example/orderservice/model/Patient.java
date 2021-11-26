//USE THIS CODE AS REFERENCE,
//ADD ANY NEW COLUMNS, OR VARIABLES AS YOU FEEL FIT.
//ONCE DONE USING AS REFERENCE, DELETE THIS  FILE.

package com.example.customerservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Patient{
@Id
private String id;
@Column
private String name;
@Column
private String disease;

public Patient(){}

public Patient(String s1, String s2, String s3){
id=s1;
name=s2;
disease=s3;
}

public String getId(){
return id;
}

public void setId(String id){
this.id=id;
}


public String getName(){
return name;
}

public void setName(String name){
this.name=name;
}

public String getDisease(){
return disease;
}

public void setDisease(String disease){
this.disease=disease;
}
}




