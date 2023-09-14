package com.veera.app.mongodbhospitalmanagement.controller;

import com.veera.app.mongodbhospitalmanagement.model.Patient;
import com.veera.app.mongodbhospitalmanagement.respository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public Patient savePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @RequestMapping(value = "/read" , method = RequestMethod.GET)
    public <List>Patient getPatient(@RequestParam("patientname") String patientname) {
        return (Patient) patientRepository.findAll();
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public Patient updatePatient(@RequestParam("patientname") String patientname, @RequestParam("hospitalname") String hospitalname) {
        Patient patient=patientRepository.findBypatientname(patientname);
        patient.setHospitalname(hospitalname);
        return patientRepository.save(patient);
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public String deletePatient(@RequestParam("patientname") String patientname) {
        patientRepository.deleteBypatientname(patientname);
        return "deleted";
    }
}
