package com.wealthsystems.challenge.repository;

import com.wealthsystems.challenge.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>{
    //Deixo vazio, pois herda de JPA
}

