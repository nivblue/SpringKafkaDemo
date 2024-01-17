package org.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@Log4j2
@SpringBootApplication
public class KafkaProducerDemo {
    public static void main(String[] args) {
        log.warn("starting producer");
        log.debug("debug starting producer");
        SpringApplication.run(KafkaProducerDemo.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            for (int i = 0; i < 80; i++) {
                kafkaTemplate.send("TEST_TOPIC", "hello niv " + i);
            }
        };
    }
}