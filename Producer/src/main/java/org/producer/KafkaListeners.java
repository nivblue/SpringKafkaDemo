package org.producer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(topics = "TEST_TOPIC", groupId = "groupId")
    void listener(String data) {
        System.out.println("data received : " + data);
    }
}
