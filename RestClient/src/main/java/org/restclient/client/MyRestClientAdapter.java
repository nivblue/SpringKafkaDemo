package org.restclient.client;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.reactive.function.client.WebClient;

@Log4j2
public class MyRestClientAdapter {
    private final WebClient webClient;

    public MyRestClientAdapter() {
        webClient = WebClient.builder().build();
    }

    public String getRequest(String url) {
        try {
            return webClient
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            log.error(e);

            return "";
        }
    }

    public <T> String postRequest(String url, T message) {
        try {
            return webClient
                    .post()
                    .uri(url)
                    .bodyValue(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            log.error(e);

            return "";
        }
    }
}
