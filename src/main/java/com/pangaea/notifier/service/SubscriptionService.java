package com.pangaea.notifier.service;

import com.pangaea.notifier.dto.SubscriptionRequest;
import com.pangaea.notifier.model.Subscription;

public interface SubscriptionService {
    Subscription create(String topic, SubscriptionRequest request);
}
