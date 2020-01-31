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
import java.util.List;

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
    public ResponseEntity<Request> findById(@PathVariable(name = "id", required = true) Long idRequest){
        Request request = requestService.findById(idRequest);
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

    @RequestMapping(value = "request/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> ok(@PathVariable(name = "id") Long id) {
        requestService.conffirmation(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build(); //Ja retorna 201
    }

    @RequestMapping(value = "request/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        requestService.cancel(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build(); //Ja retorna 201
    }

}

