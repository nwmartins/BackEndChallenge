package com.wealthsystems.challenge.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "request")
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    //Pedido conhece os itens
    @OneToMany(mappedBy = "id.request") //Id da classe ItemRequest + .Pedido informando que vem da classe auxiliar ItemRequestPK
    private Set<ItemRequest> items = new HashSet<>(); //Set = Java garante q n tenha Item repetido

    @ManyToOne
    @JoinColumn(name="consumer_id")
    private Consumer consumer;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="request")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    public Request(Long id, String status, Consumer consumer, Payment payment, Delivery delivery) {
        this.id = id;
        this.status = status;
        this.consumer = consumer;
        this.payment = payment;
        this.delivery = delivery;
    }

    public Request() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Set<ItemRequest> getItems() {
        return items;
    }

    public void setItems(Set<ItemRequest> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(id, request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
