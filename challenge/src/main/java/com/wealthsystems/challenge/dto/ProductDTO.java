package com.wealthsystems.challenge.dto;

import com.wealthsystems.challenge.model.Product;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ProductDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "can't be empty!")
    @Length(min = 2, max = 100, message = "name must be between 2 and 100 characters")
    private String name;

    public ProductDTO() {
    }

    public ProductDTO(Product p) {
        id = p.getId();
        name = p.getName();
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
}
