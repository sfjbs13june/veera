package com.veera.app.veerahospitalsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "pid" )
    private int pid;
    @Column(name = "patientname" )
    private String patientname;
    @Column(name = "patientid" )
    private int patientid;
    @Column(name = "hosiptalname" )
    private String hosiptalname;
    @Column(name = "disease" )
    private String disease;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getHosiptalname() {
        return hosiptalname;
    }

    public void setHosiptalname(String hosiptalname) {
        this.hosiptalname = hosiptalname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
