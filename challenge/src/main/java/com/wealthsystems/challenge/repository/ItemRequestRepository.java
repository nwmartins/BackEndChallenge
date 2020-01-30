package com.wealthsystems.challenge.repository;

import com.wealthsystems.challenge.model.ItemRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRequestRepository extends JpaRepository<ItemRequest, Long>{
    //Deixo vazio, pois herda de JPA
}

