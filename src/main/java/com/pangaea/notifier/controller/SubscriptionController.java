package com.pangaea.notifier.controller;

import com.pangaea.notifier.dto.SubscriptionRequest;
import com.pangaea.notifier.dto.SubscriptionResponse;
import com.pangaea.notifier.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subscribe")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/{topic}")
    public SubscriptionResponse create(@PathVariable String topic, @RequestBody @Validated SubscriptionRequest request) {
        subscriptionService.create(topic, request);

        return new SubscriptionResponse(topic, request.getUrl());
    }
}
