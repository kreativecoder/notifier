package com.pangaea.notifier.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@Component
public class HTTPSender {
    private final RestTemplate restTemplate;

    @Async
    public CompletableFuture<Void> send(String url, String message) {
        return CompletableFuture.runAsync(() -> {
            try {
                log.info("Sending to subscriber => {}", url);
                restTemplate.postForEntity(url, message, String.class);
            } catch (RestClientException ex) {
                ex.printStackTrace();
                log.info("Error while sending message {} to subscriber {}.", message, url);
            }
        });
    }
}
