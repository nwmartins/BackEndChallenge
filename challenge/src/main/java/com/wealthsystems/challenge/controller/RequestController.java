package com.wealthsystems.challenge.controller;

import com.wealthsystems.challenge.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api") //Sempre depois da porta /api + restante da URL
public class RequestController {

    //Controlador REST, irá acessar a camada de Serviços = Services;

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "requests", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(requestService.findAll());
    }

    @RequestMapping(value = "request/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable(name = "id", required = true) Long idRequest){
        return ResponseEntity.ok().body(requestService.findById(idRequest));
    }




}

