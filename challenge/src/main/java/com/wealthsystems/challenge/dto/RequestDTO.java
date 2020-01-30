package com.wealthsystems.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wealthsystems.challenge.model.ItemRequest;

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

    //Delivery
    @NotEmpty(message="can't be empty!")
    private String deliveryMode;

    //Consumer
    @NotEmpty(message="can't be empty!")
    private String name;
    @NotEmpty(message="can't be empty!")
    private String phone;
    @NotEmpty(message="can't be empty!")
    @Email(message="invalid Email")
    private String email;

    @NotEmpty(message="can't be empty!")
    private Set<ItemRequest> items = new HashSet<>();

    public RequestDTO() {
    }

    public String getStatus() {
        return status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ItemRequest> getItems() {
        return items;
    }

    public void setItems(Set<ItemRequest> items) {
        this.items = items;
    }
}
