package com.wealthsystems.challenge.repository;

import com.wealthsystems.challenge.datasource.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    //Deixo vazio, pois herda de JPA
}
