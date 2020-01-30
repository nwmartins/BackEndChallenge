package com.wealthsystems.challenge.service;

import com.wealthsystems.challenge.model.Product;
import com.wealthsystems.challenge.repository.ProductRepository;
import com.wealthsystems.challenge.service.exception.DataIntegrityException;
import com.wealthsystems.challenge.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Product save(Product product) {
        product.setId(null); //Pra ter certeza que o registro e novo
        return productRepository.save(product);
    }

    public Product update(Product product) {
        findById(product.getId()); //Caso o objeto n existir, ja ira retornar exception
        return productRepository.save(product);
    }

    public void delete(Long id) {
        findById(id); //Caso o objeto n existir, ja ira retornar exception
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Can't Delete!");
        }
    }

}