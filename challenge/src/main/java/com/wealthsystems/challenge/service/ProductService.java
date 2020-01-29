package com.wealthsystems.challenge.service;

import com.wealthsystems.challenge.datasource.model.Product;
import com.wealthsystems.challenge.repository.ProductRepository;
import com.wealthsystems.challenge.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    //Objeto de Serviço, acessa a camada de Acesso a Dados = Repository

    @Autowired //Instancia pelo Spring;
    ProductRepository productRepository;

    public List<Product> findAll() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
            throw new ObjectNotFoundException("Products not found!");
        return products;
    }

    public Product findById(Long id) {
        Optional<Product> p = productRepository.findById(id);
        return p.orElseThrow(() -> new ObjectNotFoundException(
                "Product not found! Id: " + id));
    }

}