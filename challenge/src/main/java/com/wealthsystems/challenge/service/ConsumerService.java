package com.wealthsystems.challenge.service;

import java.util.List;
import java.util.Optional;

import com.wealthsystems.challenge.model.Consumer;
import com.wealthsystems.challenge.repository.ConsumerRepository;
import com.wealthsystems.challenge.service.exception.DataIntegrityException;
import com.wealthsystems.challenge.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    //Objeto de Serviço, acessa a camada de Acesso a Dados = Repository

    @Autowired //Instancia pelo Spring;
    ConsumerRepository consumerRepository;

    public List<Consumer> findAll() {
        List<Consumer> consumers = consumerRepository.findAll();
        if (consumers.isEmpty())
            throw new ObjectNotFoundException("Consumers not found!");
        return consumers;
    }

    public Consumer findById(Long id) {
        Optional<Consumer> c = consumerRepository.findById(id);
        //orElseThrow = Funcao q instancia uma exception, Lambda sem argumentos que retona minha classe
        return c.orElseThrow(() -> new ObjectNotFoundException(
                "Consumer not found! Id: " + id));
    }

    public Consumer save(Consumer consumer) {
        consumer.setId(null); //Pra ter certeza que o registro e novo
        return consumerRepository.save(consumer);
    }

    public Consumer update(Consumer consumer) {
        findById(consumer.getId()); //Caso o objeto n existir, ja ira retornar exception
        return consumerRepository.save(consumer);
    }

    public void delete(Long id) {
        findById(id); //Caso o objeto n existir, ja ira retornar exception
        try {
            consumerRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Can't Delete!");
        }
    }

}