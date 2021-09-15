package com.pangaea.notifier.service.impl;

import com.pangaea.notifier.service.PublicationService;
import com.pangaea.notifier.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PublicationServiceImpl implements PublicationService {
    private final SubscriptionService subscriptionService;
    private final HTTPSender httpSender;

    @Override
    public void create(String topic, String request) {
        var subscribers = subscriptionService.retrieveSubscribersByTopic(topic);
        subscribers.forEach(subscriber -> httpSender.send(subscriber, request));
    }
}
