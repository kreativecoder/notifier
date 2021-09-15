package com.pangaea.notifier.controller;

import com.pangaea.notifier.service.PublicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/publish")
public class PublicationController {
    private final PublicationService publicationService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/{topic}")
    public void create(@PathVariable String topic, @RequestBody String request) {
        log.info("Request: {} ", request);
        publicationService.create(topic, request);
    }
}
