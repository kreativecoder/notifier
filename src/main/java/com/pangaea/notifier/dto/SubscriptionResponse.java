package com.pangaea.notifier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SubscriptionResponse {
    private String url;
    private String topic;
}
