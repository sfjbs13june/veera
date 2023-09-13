package com.veera.app.mongodbhospitalmanagement.controller;


import com.veera.app.mongodbhospitalmanagement.model.Hospital;
import com.veera.app.mongodbhospitalmanagement.model.Patient;
import com.veera.app.mongodbhospitalmanagement.respository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/save")
    public Patient savePatientDetails(@RequestBody Patient patient){

        return patientRepository.save(patient);
    }

    @GetMapping("/get")
    public List<Patient> getPatientdetails()
    {

        return (List<Patient>) patientRepository.findAll();
    }

    @PutMapping("/update")
    public String updatePatientDetails(@RequestParam("patientname") String patientname, @RequestParam("hospitalname") String hospitalname) {
        Patient patient=patientRepository.findByPatientName(patientname);
        patient.setHospitalname(hospitalname);
        patientRepository.save(patient);
        return "updated succesfully";
    }

    @DeleteMapping("/delete")
    public String deletePatientDetails(@RequestParam("patientname") String patientname){
        patientRepository.deleteById(patientname);
        return "deleted Succesfully";
    }


}
