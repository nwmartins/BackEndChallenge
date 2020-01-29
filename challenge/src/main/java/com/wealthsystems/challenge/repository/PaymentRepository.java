package com.wealthsystems.challenge.repository;

import com.wealthsystems.challenge.datasource.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
    //Deixo vazio, pois herda de JPA
}

