package com.veera.app.veeraspringmysqlapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospital {

    @Id
    @GeneratedValue
    @Column(name ="hid")
    private int hid;
    @Column(name = "hospitalname")
    private String hospitalname;

    @Column(name ="hospitalid")
    private String hospitalid;

    public Hospital(){}

    public Hospital(int hid, String hospitalname, String hospitalid) {
        this.hid = hid;
        this.hospitalname = hospitalname;
        this.hospitalid = hospitalid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid;
    }
}
