package com.example.newShop.api.addProducts.request;

import com.example.newShop.dao.entity.Type;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class ProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String globalCodeItemNumber;

    @NotBlank
    private BigDecimal price;

    @NotNull
    private Type type;

    public String getName() {
        return name;
    }

    public ProductRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getGlobalCodeItemNumber() {
        return globalCodeItemNumber;
    }

    public ProductRequest setGlobalCodeItemNumber(String globalCodeItemNumber) {
        this.globalCodeItemNumber = globalCodeItemNumber;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductRequest setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Type getType() {
        return type;
    }

    public ProductRequest setType(Type type) {
        this.type = type;
        return this;
    }
}
