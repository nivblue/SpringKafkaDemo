package org.restclient;

import lombok.extern.log4j.Log4j2;
import org.sharedobjects.rest.MessageRequest;
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



        System.out.println("response : ");
        System.out.println(testGetResponse);


        MessageRequest messageRequest = new MessageRequest("Testing rest client using shared package");

//        String testPostResponse = webClient
//                .post()
//                .uri(sendMessageUrl)
//                .bodyValue()
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//        System.out.println("Post response : ");
//        System.out.println(testPostResponse);
    }
}