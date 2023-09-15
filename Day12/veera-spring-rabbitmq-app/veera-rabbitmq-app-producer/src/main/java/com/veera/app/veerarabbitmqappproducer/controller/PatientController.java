package com.veera.app.veerarabbitmqappproducer.controller;

import com.veera.app.veerarabbitmqappproducer.model.Hospital;
import com.veera.app.veerarabbitmqappproducer.model.Patient;
import com.veera.app.veerarabbitmqappproducer.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class PatientController {
    @Autowired
    RabbitMQSender rabbitMQSender;


    @PostMapping(value = "/patient")
    public String postPatient(@RequestBody Patient patient){
        rabbitMQSender.patientsend(patient);
        return "Message sent to the RabbitMQ  Successfully";
    }

    @GetMapping(value = "/patproducer")
    public String producer(@RequestParam("pname") String pname, @RequestParam("pid") String pid,@RequestParam("disease") String disease) {
        Patient pat=new Patient();
        pat.setPname("pname");
        pat.setPid("pid");
        pat.setDisease("disease");
        rabbitMQSender.patientsend(pat);
        return "Message sent to the RabbitMQ  Successfully";
    }


}
