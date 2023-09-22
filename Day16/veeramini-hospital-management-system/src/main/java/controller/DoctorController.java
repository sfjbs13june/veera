package controller;

import model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.AppointmentRepository;

import java.util.List;

@RestController
@RequestMapping(value ="/doctor")
public class DoctorController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping(value ="/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping(value = "/doctorappointment")
    public Appointment getAppointment(@RequestParam String docterName){
        Appointment appointment=appointmentRepository.findBydoctorName(docterName);
        return appointment;
    }
}
