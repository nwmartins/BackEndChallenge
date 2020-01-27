package com.wealthsystems.challenge.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wealthsystems.challenge.datasource.model.Consumer;
import com.wealthsystems.challenge.repository.ConsumerRepository;
import com.wealthsystems.challenge.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService{

    @Autowired
    ConsumerRepository consumerRepository;

    @Override
    public List<Consumer> findAll() {
        // TODO Auto-generated method stub
        return consumerRepository.findAll();
    }

    @Override
    public Consumer findById(Long id) {
        // TODO Auto-generated method stub
        return consumerRepository.findById(id).get();
    }

    @Override
    public Consumer save(Consumer consumer) {
        // TODO Auto-generated method stub
        return consumerRepository.saveAndFlush(consumer);
    }

}
