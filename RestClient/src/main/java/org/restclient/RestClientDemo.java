package org.restclient;

import lombok.extern.log4j.Log4j2;
import org.restclient.client.MyRestClientAdapter;
import org.sharedobjects.rest.MessageRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.restclient.utils.Constants.SEND_MESSAGE_URL;
import static org.restclient.utils.Constants.TEST_URL;

@Log4j2
@SpringBootApplication
public class RestClientDemo {
    public static void main(String[] args) {
        log.info("Starting Rest Client");
        SpringApplication.run(RestClientDemo.class, args);
        MyRestClientAdapter myRestClientAdapter = new MyRestClientAdapter(); // Rename
        MessageRequest messageRequest = new MessageRequest("Testing rest client using shared package");

        String testGetResponse = myRestClientAdapter.getRequest(TEST_URL);
        String testPostResponse = myRestClientAdapter.postRequest(SEND_MESSAGE_URL, messageRequest);

        log.debug("response : ");
        log.debug(testGetResponse);

        log.debug("Post response : ");
        log.debug(testPostResponse);
    }
}