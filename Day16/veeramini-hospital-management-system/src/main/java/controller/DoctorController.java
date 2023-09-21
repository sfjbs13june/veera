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
    AppointmentRepository appointmentRepository;

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/doctorappointment") public List<Appointment> getAppointment(@RequestParam String doctorName){
        Appointment appointment=appointmentRepository.findBydoctorName(doctorName);
        return (List<Appointment>) appointment;
    }

}
