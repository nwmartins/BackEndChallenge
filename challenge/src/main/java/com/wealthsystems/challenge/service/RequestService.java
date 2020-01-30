package com.wealthsystems.challenge.service;

import com.wealthsystems.challenge.dto.RequestDTO;
import com.wealthsystems.challenge.model.*;
import com.wealthsystems.challenge.repository.*;
import com.wealthsystems.challenge.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    //Objeto de Serviço, acessa a camada de Acesso a Dados = Repository

    @Autowired //Instancia pelo Spring;
    RequestRepository requestRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ConsumerRepository consumerRepository;
    @Autowired
    ItemRequestRepository itemRequestRepository;


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

    public Request save(Request request) {
        request.setId(null); //Pra ter certeza que o registro e novo
        request.setStatus("pending confirmation");

        //ItemRequest
        Double sum = 0.0;
        for (ItemRequest ir : request.getItems()) {
            sum = sum + (ir.getUnits() + ir.getProduct().getUnitPrice()); //ir.getAmount();
            ir.setRequest(request); //Vinculo cada Item ao Pedido
        }

        itemRequestRepository.saveAll(request.getItems());
        //End ItemRequest

        //Payment
        request.getPayment().setId(null);
        request.getPayment().setAmount(sum);
        request.getPayment().setInstallValue(sum / request.getPayment().getInstallments());
        request.getPayment().setRequest(request);

        paymentRepository.save(request.getPayment());
        //End Payment

        //Consumer
        request.getConsumer().setId(null);
        request.getConsumer().setRequests(Arrays.asList(request));

        consumerRepository.save(request.getConsumer());

        //End Consumer

        //Delivery
        request.getDelivery().setId(null);
        request.getDelivery().setRequests(Arrays.asList(request));
        //End Delivery

        return request;
    }

//    public Request fromDTO(RequestDTO dto) {
//        Consumer consumer = new Consumer(null, dto.getName(), dto.getPhone(), dto.getEmail());
//        Payment payment = new Payment(null, dto.getPaymentMode(), 0.00, dto.getInstallments(), 0.00);
//        Delivery delivery = new Delivery(null, dto.getDeliveryMode());
//        Request request = new Request(null, dto.getStatus(), consumer, payment, delivery);
//
//        return request;
//    }

}