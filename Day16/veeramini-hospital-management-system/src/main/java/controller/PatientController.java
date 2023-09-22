package controller;

import model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.AppointmentRepository;

import java.util.List;

@RestController
@RequestMapping(value ="/patient")
public class PatientController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping(value="/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping(value="/myappointment")
    public Appointment getAppointments(@RequestParam String patientName){
        Appointment appointment=appointmentRepository.findBypatientName(patientName);
        return  appointment;
    }


}

