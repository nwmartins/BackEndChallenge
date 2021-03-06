package com.wealthsystems.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mode;
    private Double amount;
    private Integer installments;
    private Double installValue;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="request_id")
    @MapsId
    private Request request;

    public Payment(Long id, String mode, Double amount, Integer installments, Double installValue, Request request) {
        this.id = id;
        this.mode = mode;
        this.amount = amount;
        this.installments = installments;
        this.installValue = installValue;
        this.request = request;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public Double getInstallValue() {
        return installValue;
    }

    public void setInstallValue(Double installValue) {
        this.installValue = installValue;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
