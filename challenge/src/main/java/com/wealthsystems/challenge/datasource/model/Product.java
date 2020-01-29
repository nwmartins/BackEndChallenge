package com.wealthsystems.challenge.datasource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "product")//Nome da tabela na DB
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String barcode;

    @ManyToMany(mappedBy = "products")
    private List<Manufacturer> manufacturers = new ArrayList<>();
    private Double unitPrice;

    //Pedido conhece os itens
    @JsonIgnore
    @OneToMany(mappedBy = "id.product") //Id da classe ItemRequest + .Products informando que vem da classe auxiliar ItemRequestPK
    private Set<ItemRequest> items = new HashSet<>(); //Set = Java garante q n tenha Item repetido

    public Product(Long id, String name, String description, String barcode, Double unitPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.barcode = barcode;
        this.unitPrice = unitPrice;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
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
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
