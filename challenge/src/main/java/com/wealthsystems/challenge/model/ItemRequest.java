package com.wealthsystems.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "item_request")
public class ItemRequest implements Serializable {

    @JsonIgnore
    @EmbeddedId //Representa chave composta (Tipo auxiliar)
    private ItemRequestPK id = new ItemRequestPK();

    private Double units;

    public ItemRequest() {
    }

    public ItemRequest(Request request, Product product, Double units) {
        //Pois ItemRequestPK e uma coisa do JPA
        id.setProduct(product);
        id.setRequest(request);
        this.id = id;
        this.units = units;
    }

    //Para poder ter acesso a classe fora da classe ItemRequest
    //Como ignoro o Id, deve se ignorar os Get tmb, evitando referencia ciclica
    @JsonIgnore
    public Request getRequest() {
        return id.getRequest();
    }

    public Product getProduct() {
        return id.getProduct();
    }
    //--------------------------------------------------------

    public void setRequest(Request request) {
        id.setRequest(request);
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public ItemRequestPK getId() {
        return id;
    }

    public void setId(ItemRequestPK id) {
        this.id = id;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getAmount() {
        return (getProduct().getUnitPrice() * units);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRequest that = (ItemRequest) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
