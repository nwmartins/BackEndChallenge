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
    private RequestRepository requestRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ConsumerRepository consumerRepository;
    @Autowired
    private ItemRequestRepository itemRequestRepository;
    @Autowired
    private ProductRepository productRepository;


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

    public Request fromDTO(RequestDTO dto) {
        Request r = new Request();
        r.setId(null);
        r.setConsumer(dto.getConsumer());
        r.setStatus(dto.getStatus());
        r.setDelivery(new Delivery(null, dto.getDeliveryMode()));
        r.setPayment(new Payment(null, dto.getPaymentMode(), dto.getAmount(), dto.getInstallments(), dto.getInstallValue(), null));
        r.setItems(dto.getItems());

        return r;
    }

    public void conffirmation(Long id){
        Request r = findById(id);
        if (r != null) {
            r.setStatus("Conffirmed");
            requestRepository.save(r);
        }
    }

    public void cancel(Long id){
        Request r = findById(id);
        if (r != null) {
            r.setStatus("Canceled");
            requestRepository.save(r);
        }
    }


    public Request save(Request request) {
        Double sum = 0.0;
        //try {
            //request.setId(null); //Pra ter certeza que o registro e novo
            request.setStatus("pending confirmation");
            //Consumer
            request.getConsumer().setId(null);
            request.getConsumer().setRequests(Arrays.asList(request));
            consumerRepository.save(request.getConsumer());
            //End Consumer
            //Delivery
            request.getDelivery().setId(null);
            request.getDelivery().setRequests(Arrays.asList(request));

            deliveryRepository.save(request.getDelivery());
            //End Delivery

            //ItemRequest
            for (ItemRequest ir : request.getItems()) {
                ir.setProduct(productRepository.findById(ir.getProduct().getId()).get());
                ir.setRequest(request); //Vinculo cada Item ao Pedido
                sum = sum + (ir.getUnits() * ir.getProduct().getUnitPrice()); //ir.getAmount();
            }

            //Payment
            request.getPayment().setId(null);
            request.getPayment().setAmount(sum);
            request.getPayment().setInstallValue(sum / request.getPayment().getInstallments());
            request.getPayment().setRequest(request);

            paymentRepository.save(request.getPayment());
            //End Payment

            itemRequestRepository.saveAll(request.getItems());
            //End ItemRequest

            request = requestRepository.save(request);


            return request;
//    } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
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