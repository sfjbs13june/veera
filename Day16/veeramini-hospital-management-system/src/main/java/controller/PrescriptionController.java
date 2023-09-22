package controller;

import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.PrescriptionRepository;

import java.util.List;

@RestController
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @PostMapping("/saveprescription")
    public Prescription saveprescription(@RequestBody Prescription prescription)
    {
        Prescription pres=prescriptionRepository.save(prescription);
        return pres;
    }

    @GetMapping("/viewprescription")
    public Prescription getprescription(@RequestParam String patientName){
        Prescription prescription=prescriptionRepository.findBypatientName(patientName);
        return prescription;
    }

    @GetMapping(value ="/get")
    public  String getData()
    {
        return "String displayed";
    }
}
