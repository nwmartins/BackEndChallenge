package com.wealthsystems.challenge.controller;

import java.util.List;
import java.util.Optional;

import com.wealthsystems.challenge.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wealthsystems.challenge.datasource.model.Consumer;
import com.wealthsystems.challenge.service.ConsumerService;

@RestController
@RequestMapping(value = "api") //Sempre depois da porta /api + restante da URL
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;
    @Autowired
    private ConsumerRepository consumerRepository;

    @GetMapping(path = "/consumer/id/{id}")
    public Optional<Consumer> searchById(@PathVariable(name = "id", required = true) Long idConsumer) {
        return consumerRepository.findById(idConsumer);

    }

    @GetMapping(path = "/consumers")
    public List<Consumer> searchAll(Long idConsumer) {
        return consumerRepository.findAll();

    }

    @PostMapping(path = "/consumer/save")
    public void save(@RequestBody Consumer consumer) {
        consumerRepository.save(consumer);
    }

    @DeleteMapping(path = "consumer/delete/{id}")
    public void delete(@PathVariable(name = "id", required = true) Long idConsumer) {
        consumerRepository.deleteById(idConsumer);
    }

//    @PutMapping(path = "consumer/update/{id}")
//    public Consumer update(@PathVariable(name = "id", required = true) Long idConsumer) {
//        return consumerRepository.
//    }



}

