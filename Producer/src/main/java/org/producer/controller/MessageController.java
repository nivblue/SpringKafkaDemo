package org.producer.controller;

import org.producer.record.MessageRequest;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kafka/test/")
public class MessageController {

//    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        System.out.println("Sending data : " + request.message());
//        log.debug("Sending data : " + request.message());
        kafkaTemplate.send("TEST_TOPIC", request.message());
    }
}
