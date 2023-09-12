package com.veera.app.veerahospitalsystem.controller;

import com.veera.app.veerahospitalsystem.model.Hospital;
import com.veera.app.veerahospitalsystem.model.Patient;
import com.veera.app.veerahospitalsystem.repository.HospitalRepository;
import com.veera.app.veerahospitalsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;

    @PostMapping("/save")
    public Hospital saveHospitalDetails(@RequestBody Hospital hospital){
        return hospitalRepository.save(hospital);
    }

    @GetMapping("/get")
    public List<Hospital> gethospitaldetails()
    {
        return (List<Hospital>) hospitalRepository.findAll();
    }

    @PutMapping("/update")
    public String updateHospitalDetails(@RequestParam("pid") int pid,@RequestBody Hospital hospital){
        hospitalRepository.save(hospital);
        return "updated Succesfully";
    }


    @DeleteMapping("/delete")
    public String deleteHospitalDetails(@RequestParam("pid") int pid){
        hospitalRepository.deleteById(pid);
        return "deleted Succesfully";
    }
}
