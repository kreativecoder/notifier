package com.pangaea.notifier.service;

import com.pangaea.notifier.dto.SubscriptionRequest;
import com.pangaea.notifier.model.Subscription;

import java.util.Set;

public interface SubscriptionService {
    Subscription create(String topic, SubscriptionRequest request);

    Set<String> retrieveSubscribersByTopic(String topic);
}
