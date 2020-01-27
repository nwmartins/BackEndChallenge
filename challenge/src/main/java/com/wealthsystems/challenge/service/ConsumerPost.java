package com.wealthsystems.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wealthsystems.challenge.datasource.model.Consumer;
import com.wealthsystems.challenge.repository.ConsumerRepository;

public class ConsumerPost {
    @Autowired
    private ConsumerRepository consumerRepository;

    public void post(Consumer consumer) {
        consumerRepository.saveAndFlush(consumer);
    }

}

