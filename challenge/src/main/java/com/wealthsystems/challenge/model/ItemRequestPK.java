package com.wealthsystems.challenge.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

//Classe sub-tipo
@Embeddable
public class ItemRequestPK implements Serializable {

    //Conhece seus produtos
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    //Conhece seus pedidos
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    //Com base nos 2 atributos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRequestPK that = (ItemRequestPK) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(request, that.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, request);
    }
}
