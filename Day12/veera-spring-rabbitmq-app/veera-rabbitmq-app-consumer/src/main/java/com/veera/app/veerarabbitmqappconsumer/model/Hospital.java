package com.veera.app.veerarabbitmqappconsumer.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Hospital.class)
public class Hospital {

    private String hid;
    private String hname;
    private String address;

    public Hospital(){}

    public Hospital(String hid, String hname, String address) {
        this.hid = hid;
        this.hname = hname;
        this.address = address;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hospital{" + "hid='" + hid + '\'' + ", hname='" + hname + '\'' + ", address='" + address + '\'' + '}';
    }
}
