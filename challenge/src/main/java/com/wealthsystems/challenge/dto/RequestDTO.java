package com.wealthsystems.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wealthsystems.challenge.model.Consumer;
import com.wealthsystems.challenge.model.ItemRequest;
import com.wealthsystems.challenge.model.Request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RequestDTO implements Serializable {

    //Request
    private String status;

    //Payment
    @NotEmpty(message="can't be empty!")
    private String paymentMode;
    @NotEmpty(message="can't be empty!")
    private Integer installments;
    private Double amount;
    private Double installValue;

    //Delivery
    @NotEmpty(message="can't be empty!")
    private String deliveryMode;

    private Consumer consumer;

    @NotEmpty(message="can't be empty!")
    private Set<ItemRequest> items = new HashSet<>();

    public RequestDTO() {
    }

    public RequestDTO(Request r) {
        status = r.getStatus();
        paymentMode = r.getPayment().getMode();
        installments = r.getPayment().getInstallments();
        amount = r.getPayment().getAmount();
        installValue = r.getPayment().getInstallValue();
        deliveryMode = r.getDelivery().getMode();
        consumer = r.getConsumer();
        items = r.getItems();
    }

    public String getStatus() {
        return status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInstallValue() {
        return installValue;
    }

    public void setInstallValue(Double installValue) {
        this.installValue = installValue;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Set<ItemRequest> getItems() {
        return items;
    }

    public void setItems(Set<ItemRequest> items) {
        this.items = items;
    }
}
