package org.producer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaProducerDemo {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerDemo.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            for (int i = 0; i < 100000; i++) {
                kafkaTemplate.send("TEST_TOPIC", "hello niv " + i);
            }
        };
    }
}