package com.wealthsystems.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ConsumerDTO implements Serializable {

    @JsonProperty("name")
    private String nome;
    private String email;

    public ConsumerDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
