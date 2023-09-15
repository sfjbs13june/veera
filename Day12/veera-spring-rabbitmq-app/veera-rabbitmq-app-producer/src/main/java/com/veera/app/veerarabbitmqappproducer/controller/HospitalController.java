package com.veera.app.veerarabbitmqappproducer.controller;


import com.veera.app.veerarabbitmqappproducer.model.Hospital;
import com.veera.app.veerarabbitmqappproducer.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class HospitalController {
    @Autowired
    RabbitMQSender rabbitMQSender;


    @PostMapping(value = "/hospital")
    public String postHospital(@RequestBody Hospital hospital){

        rabbitMQSender.hospitalsend(hospital);

        return "Message sent to the RabbitMQ  Successfully";
    }

    @GetMapping(value = "/hproducer")
    public String producer(@RequestParam("hname") String hname, @RequestParam("hid") String hid,@RequestParam("address") String adress) {

        Hospital hos=new Hospital();
        hos.setHname("hname");
        hos.setHid("hid");
        hos.setAddress("address");
        rabbitMQSender.hospitalsend(hos);

        return "Message sent to the RabbitMQ  Successfully";
    }


}