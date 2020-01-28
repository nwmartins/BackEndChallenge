package com.wealthsystems.challenge.controller;

import com.wealthsystems.challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api") //Sempre depois da porta /api + restante da URL
public class ProductController {

    //Controlador REST, irá acessar a camada de Serviços = Services;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable(name = "id", required = true) Long idProduct){
        return ResponseEntity.ok().body(productService.findById(idProduct));
    }




}

