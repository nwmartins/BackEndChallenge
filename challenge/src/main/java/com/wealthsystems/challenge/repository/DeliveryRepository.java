package com.wealthsystems.challenge.repository;

import com.wealthsystems.challenge.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{
    //Deixo vazio, pois herda de JPA
}

