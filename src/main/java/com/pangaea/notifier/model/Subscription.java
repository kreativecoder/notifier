package com.pangaea.notifier.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document("subscriptions")
public class Subscription {
    @Id
    private String id;
    private String topic;
    private Set<String> subscribers;
}
