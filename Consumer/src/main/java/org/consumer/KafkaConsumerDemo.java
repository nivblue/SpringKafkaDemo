package org.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class KafkaConsumerDemo {
    public static void main(String[] args) {
//        new SpringApplicationBuilder(KafkaConsumerDemo.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
        SpringApplication.run(KafkaConsumerDemo.class, args);
    }
}