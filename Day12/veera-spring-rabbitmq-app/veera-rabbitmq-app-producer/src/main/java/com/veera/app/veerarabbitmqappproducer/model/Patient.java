package com.veera.app.veerarabbitmqappproducer.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Patient.class)
public class Patient {
    private String pid;
    private String pname;
    private String disease;

    public Patient(){}

    public Patient(String pid, String pname, String disease) {
        this.pid = pid;
        this.pname = pname;
        this.disease = disease;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Patient{" + "pid='" + pid + '\'' + ", pname='" + pname + '\'' + ", disease='" + disease + '\'' + '}';
    }
}

