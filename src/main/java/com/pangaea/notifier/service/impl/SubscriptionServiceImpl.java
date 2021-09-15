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
        var optSubscription = repository.findByTopic(topic);
        var subscription = new Subscription();
        if (optSubscription.isPresent()) {
            subscription = optSubscription.get();
            var subscribers = subscription.getSubscribers();
            subscribers.add(request.getUrl());
            subscription.setSubscribers(subscribers);
        } else {
            subscription.setTopic(topic);
            subscription.setSubscribers(Set.of(request.getUrl()));
        }

        return repository.save(subscription);
    }

    @Override
    public Set<String> retrieveSubscribersByTopic(String topic) {
        return repository.findByTopic(topic)
                .map(Subscription::getSubscribers)
                .orElse(Set.of());
    }
}
