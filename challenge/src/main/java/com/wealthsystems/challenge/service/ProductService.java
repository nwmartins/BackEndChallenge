package com.wealthsystems.challenge.service;

import com.wealthsystems.challenge.datasource.model.Product;
import com.wealthsystems.challenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    //Objeto de Serviço, acessa a camada de Acesso a Dados = Repository

    @Autowired //Instancia pelo Spring;
    ProductRepository productRepository;

//    public Consumer findById(Long id) {
//        return consumerRepository.findById(id).get();
//    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

//    List<Consumer> findAll();
//    Consumer findById(Long id);
//    Consumer save(Consumer consumer);
//    Consumer update(Consumer consumer, Long id);
//    void deleteById(Long id);

}