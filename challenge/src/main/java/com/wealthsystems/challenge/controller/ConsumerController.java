package com.wealthsystems.challenge.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wealthsystems.challenge.model.Consumer;
import com.wealthsystems.challenge.service.ConsumerService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "api") //Sempre depois da porta /api + restante da URL
public class ConsumerController {

    //Controlador REST, irá acessar a camada de Serviços = Services;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "consumers", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(consumerService.findAll());
    }

    @RequestMapping(value = "consumer/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(consumerService.findById(id));
    }

    @RequestMapping(value = "consumer", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Consumer consumer) {
        consumer = consumerService.save(consumer);
        //Obtem a nova URI do novo Objeto para retornar no Header
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(consumer.getId()).toUri();
        return ResponseEntity.created(uri).build(); //Ja retorna 201
    }

    @RequestMapping(value = "consumer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Consumer consumer){
        consumer.setId(id);
        consumerService.update(consumer);
        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "consumer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        consumerService.delete(id);
        return ResponseEntity.noContent().build();
    }




}

