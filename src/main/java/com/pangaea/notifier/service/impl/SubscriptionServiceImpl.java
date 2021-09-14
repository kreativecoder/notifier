package com.pangaea.notifier.service.impl;

import com.pangaea.notifier.dto.SubscriptionRequest;
import com.pangaea.notifier.model.Subscription;
import com.pangaea.notifier.repository.SubscriptionRepository;
import com.pangaea.notifier.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository repository;

    @Override
    public Subscription create(String topic, SubscriptionRequest request) {
        var subscription = new Subscription();
        subscription.setTopic(topic);
        subscription.setSubscribers(Set.of(request.getUrl()));

        return repository.save(subscription);
    }
}