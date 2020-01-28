package com.wealthsystems.challenge.controller;

import java.util.List;
import java.util.Optional;

import com.wealthsystems.challenge.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wealthsystems.challenge.datasource.model.Consumer;
import com.wealthsystems.challenge.service.ConsumerService;

@RestController
@RequestMapping(value = "api") //Sempre depois da porta /api + restante da URL
public class ConsumerController {

    //Controlador REST, irá acessar a camada de Serviços = Services;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "consumer/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable(name = "id", required = true) Long idConsumer){
        return ResponseEntity.ok().body(consumerService.findById(idConsumer));
    }




}

