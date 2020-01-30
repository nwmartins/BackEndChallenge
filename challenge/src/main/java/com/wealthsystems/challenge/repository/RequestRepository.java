package com.wealthsystems.challenge.repository;

import com.wealthsystems.challenge.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{
    //Deixo vazio, pois herda de JPA
}

