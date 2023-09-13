package com.veera.app.mongodbhospitalmanagement.model;

public class Patient {

    private String patientname;
    private String patientid;
    private String hospitalname;
    private String disease;

    public Patient(){}

    public Patient(String patientname, String patientid, String hospitalname, String disease) {
        this.patientname = patientname;
        this.patientid = patientid;
        this.hospitalname = hospitalname;
        this.disease = disease;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
