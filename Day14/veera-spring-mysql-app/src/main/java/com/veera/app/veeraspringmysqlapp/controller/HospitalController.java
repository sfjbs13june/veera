package com.veera.app.veeraspringmysqlapp.controller;


import com.veera.app.veeraspringmysqlapp.model.Hospital;
import com.veera.app.veeraspringmysqlapp.repository.HospitalRepository;
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
    public String updateHospitalDetails(@RequestParam("hid") int pid,@RequestBody Hospital hospital){
        hospitalRepository.save(hospital);
        return "updated Succesfully";
    }

    @DeleteMapping("/delete")
    public String deleteHospitalDetails(@RequestParam("hid") int pid){
        hospitalRepository.deleteById(pid);
        return "deleted Succesfully";
    }
}
