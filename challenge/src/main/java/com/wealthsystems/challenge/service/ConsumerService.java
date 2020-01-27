package com.wealthsystems.challenge.service;

import java.util.List;

import com.wealthsystems.challenge.datasource.model.Consumer;

public interface ConsumerService {

    List<Consumer> findAll();
    Consumer findById(Long id);
    Consumer save(Consumer consumer);

}