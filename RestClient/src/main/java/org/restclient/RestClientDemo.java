package org.restclient;

import lombok.extern.log4j.Log4j2;
import org.restclient.record.MessageRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@Log4j2
@SpringBootApplication
public class RestClientDemo {
    public static void main(String[] args) {
        log.info("Starting Rest Client");
        SpringApplication.run(RestClientDemo.class, args);

        String testUrl = "http://localhost:8081/kafka/test/";
        String sendMessageUrl = "http://localhost:8081/kafka/test/send/";

        WebClient webClient = WebClient.builder().build();


        String testGetResponse = webClient
                .get()
                .uri(testUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("response : ");
        System.out.println(testGetResponse);


        String testPostResponse = webClient
                .post()
                .uri(sendMessageUrl)
                .bodyValue(new MessageRequest("Testing rest client"))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("response : ");
        System.out.println(testGetResponse);

        System.out.println("Post response : ");
        System.out.println(testPostResponse);
    }
}