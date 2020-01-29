package com.wealthsystems.challenge.service;

import com.wealthsystems.challenge.datasource.model.Request;
import com.wealthsystems.challenge.repository.RequestRepository;
import com.wealthsystems.challenge.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    //Objeto de Serviço, acessa a camada de Acesso a Dados = Repository

    @Autowired //Instancia pelo Spring;
            RequestRepository requestRepository;

    public List<Request> findAll() {
        List<Request> requests = requestRepository.findAll();
        if (requests.isEmpty())
            throw new ObjectNotFoundException("Requests not found!");
        return requests;
    }

    public Request findById(Long id) {
        Optional<Request> c = requestRepository.findById(id);
        //orElseThrow = Funcao q instancia uma exception, Lambda sem argumentos que retona minha classe
        return c.orElseThrow(() -> new ObjectNotFoundException(
                "Request not found! Id: " + id));
    }

}