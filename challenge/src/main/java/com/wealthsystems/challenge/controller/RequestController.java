package com.wealthsystems.challenge.controller;

import com.wealthsystems.challenge.dto.RequestDTO;
import com.wealthsystems.challenge.model.Product;
import com.wealthsystems.challenge.model.Request;
import com.wealthsystems.challenge.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

    @RequestMapping(value = "request", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody Request request) {
        request = requestService.save(request);
        //Obtem a nova URI do novo Objeto para retornar no Header
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).build(); //Ja retorna 201
    }

//    @RequestMapping(value = "request", method = RequestMethod.POST)
//    public ResponseEntity<Void> save(@Valid @RequestBody RequestDTO requestDTO) {
//        Request request = requestService.fromDTO(requestDTO);
//        request = requestService.save(request);
//        //Obtem a nova URI do novo Objeto para retornar no Header
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
//                path("/{id}").buildAndExpand(request.getId()).toUri();
//        return ResponseEntity.created(uri).build(); //Ja retorna 201
//    }




}

