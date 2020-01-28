package com.wealthsystems.challenge.service;

import java.util.List;

import com.wealthsystems.challenge.datasource.model.Consumer;
import com.wealthsystems.challenge.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    //Objeto de Serviço, acessa a camada de Acesso a Dados = Repository

    @Autowired //Instancia pelo Spring;
    ConsumerRepository consumerRepository;

//    public Consumer findById(Long id) {
//        return consumerRepository.findById(id).get();
//    }
    public List<Consumer> findAll() {
        return consumerRepository.findAll();
    }

    public Consumer findById(Long id) {
        return consumerRepository.findById(id).get();
    }

//    List<Consumer> findAll();
//    Consumer findById(Long id);
//    Consumer save(Consumer consumer);
//    Consumer update(Consumer consumer, Long id);
//    void deleteById(Long id);

}