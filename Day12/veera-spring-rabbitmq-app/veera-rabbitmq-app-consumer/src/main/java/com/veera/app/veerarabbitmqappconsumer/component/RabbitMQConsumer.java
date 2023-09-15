package com.veera.app.veerarabbitmqappconsumer.component;

import com.veera.app.veerarabbitmqappconsumer.model.Hospital;
import com.veera.app.veerarabbitmqappconsumer.model.Patient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    /*
    If you are using boot, you can simply add a Jackson2JsonMessageConverter
    @Bean to the configuration and it will be automatically wired into the listener (
     */
    @Value("${rabbitmq.queue.name}")
    String queueName;

    @Value("${rabbitmq.exchange.name}")
    String exchange;

    @Value("${rabbitmq.routingkey.name}")
    private String routingkey;
    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void recievedpatMessage(Patient patient) {
        System.out.println("Recieved Message From RabbitMQ: " + patient);
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void recievedhosMessage(Hospital hospital) {
        System.out.println("Recieved Message From RabbitMQ: " + hospital);
    }
}
