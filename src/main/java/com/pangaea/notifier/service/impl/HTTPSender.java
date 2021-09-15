package com.pangaea.notifier.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component
public class HTTPSender {
    private final RestTemplate restTemplate;

    public void send(String url, String message) {
        try {
            restTemplate.postForEntity(url, message, String.class);
        } catch (RestClientException ex) {
            ex.printStackTrace();
            log.info("Error while sending message {} to subscriber {}.", message, url);
        }
    }
}
