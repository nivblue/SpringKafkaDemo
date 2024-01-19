package org.producer.controller;

import lombok.extern.log4j.Log4j2;
import org.sharedobjects.kafka.BasicMessage;
import org.sharedobjects.rest.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

import static org.producer.utils.Constants.TEST_STRING_TOPIC;
import static org.producer.utils.Constants.TEST_TOPIC;

@Log4j2
@Controller
@RequestMapping("/kafka/test/")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

//    public MessageController(KafkaTemplate<String, >)

    @GetMapping
    public ResponseEntity<String> getTest() {
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/send/")
    public ResponseEntity<String> publish(@RequestBody MessageRequest request) {
        try {
            log.debug("Received data from rest : " + request.message());

            if (Objects.nonNull(request.message())) {
                BasicMessage newBasicMessage = convertFromRestToKafka(request);
                log.debug("Sending data : " + newBasicMessage.message());
                kafkaTemplate.send(TEST_TOPIC, newBasicMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok("Success");
    }

    private BasicMessage convertFromRestToKafka(MessageRequest request) {
        return new BasicMessage(request.message());
    }
}
