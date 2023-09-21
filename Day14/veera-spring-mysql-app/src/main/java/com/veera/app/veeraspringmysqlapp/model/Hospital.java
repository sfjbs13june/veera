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
    private String address;

    public Hospital(){}

    public Hospital(int hid, String hospitalname, String address) {
        this.hid = hid;
        this.hospitalname = hospitalname;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
