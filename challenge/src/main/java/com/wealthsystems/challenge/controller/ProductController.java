package com.wealthsystems.challenge.controller;

import com.wealthsystems.challenge.dto.ProductDTO;
import com.wealthsystems.challenge.model.Product;
import com.wealthsystems.challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api") //Sempre depois da porta /api + restante da URL
public class ProductController {

    //Controlador REST, irá acessar a camada de Serviços = Services;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> findAll(){
        List <Product> products = productService.findAll();
        //Converte uma lista para outra
        List<ProductDTO> productDTO = products.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(productDTO);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable(name = "id", required = true) Long idProduct){
        return ResponseEntity.ok().body(productService.findById(idProduct));
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Product product) {
        product = productService.save(product);
        //Obtem a nova URI do novo Objeto para retornar no Header
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build(); //Ja retorna 201
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        productService.update(product);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

