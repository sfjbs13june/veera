package controller;

import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.PrescriptionRepository;

import java.util.List;

@RestController
//@RequestMapping(value ="/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @PostMapping("/saveprescription")
    public Prescription saveprescription(@RequestBody Prescription prescription){
        return prescriptionRepository.save(prescription);
    }

    @GetMapping("/viewprescription")
    public List<Prescription> getprescription (@RequestParam String patientName){
        Prescription prescription=prescriptionRepository.findBypatientName(patientName);
        return (List<Prescription>) prescription;
    }


}
