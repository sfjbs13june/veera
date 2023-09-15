package com.veera.app.veerarabbitmqappproducer.service;

import com.veera.app.veerarabbitmqappproducer.model.Hospital;
import com.veera.app.veerarabbitmqappproducer.model.Patient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

    @Service
    public class RabbitMQSender {
        @Autowired
        private AmqpTemplate rabbitTemplate;

        @Value("${rabbitmq.exchange.name}")
        private String exchange;

        @Value("${rabbitmq.routingkey.name}")
        private String routingkey;

        public void hospitalsend(Hospital hospital) {
            rabbitTemplate.convertAndSend(exchange, routingkey, hospital);
            System.out.println("Send hospitalmsg = " + hospital);

        }

        public void patientsend(Patient patient) {
            rabbitTemplate.convertAndSend(exchange, routingkey, patient);
            System.out.println("Send patientmsg = " + patient);
        }

    }

