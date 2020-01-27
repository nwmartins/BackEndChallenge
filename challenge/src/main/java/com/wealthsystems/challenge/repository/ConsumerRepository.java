package com.wealthsystems.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wealthsystems.challenge.datasource.model.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Long>{
    //Deixo vazio, pois herda de JPA
}

