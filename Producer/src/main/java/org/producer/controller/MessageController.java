package org.producer.controller;

import lombok.extern.log4j.Log4j2;
import org.producer.record.MessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@Log4j2
@Controller
@RequestMapping("/kafka/test/")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/send/")
    public ResponseEntity<String> publish(@RequestBody MessageRequest request) {
        try {
            log.debug("Received data from rest : " + request.message());

            if (Objects.nonNull(request.message())) {
                log.debug("Sending data : " + request.message());
                kafkaTemplate.send("TEST_TOPIC", request.message());
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok("Success");
    }
}
