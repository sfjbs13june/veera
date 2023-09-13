package com.veera.app.mongodbhospitalmanagement.model;

public class Hospital {

    private String hospitalname;
    private String hospitalid;
    private String address;

    public Hospital(){}

    public Hospital(String hospitalname, String hospitalid, String address) {
        this.hospitalname = hospitalname;
        this.hospitalid = hospitalid;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
