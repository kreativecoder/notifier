package com.pangaea.notifier.service.impl;

import com.pangaea.notifier.service.PublicationService;
import com.pangaea.notifier.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PublicationServiceImpl implements PublicationService {
    private final SubscriptionService subscriptionService;
    private final HTTPSender httpSender;

    @Override
    public void create(String topic, String request) {
        var subscribers = subscriptionService.retrieveSubscribersByTopic(topic);
        subscribers.stream()
                .map(s -> httpSender.send(s, request))
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
