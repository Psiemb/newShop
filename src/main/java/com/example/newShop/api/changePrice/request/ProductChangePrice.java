package com.example.newShop.api.changePrice.request;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ProductChangePrice {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public ProductChangePrice setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductChangePrice setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
