package controller;

import model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.AppointmentRepository;

import java.util.List;

@RestController
@RequestMapping(value="/patient")
public class PatientController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/myappointments")
    public List<Appointment> getMyappointments(@RequestParam String patientName){
        Appointment appointment= appointmentRepository.findBypatientName(patientName);
        return (List<Appointment>) appointment;
    }


}
