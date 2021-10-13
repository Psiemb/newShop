package com.example.newShop.api.findByName.response;

import java.math.BigDecimal;

public class ProductResponseByName {

    private Long id;
    private String name;
    private String globalCodeItemNumber;
    private BigDecimal price;
    private TypeResponseByName type;

    public Long getId() {
        return id;
    }

    public ProductResponseByName setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseByName setName(String name) {
        this.name = name;
        return this;
    }

    public String getGlobalCodeItemNumber() {
        return globalCodeItemNumber;
    }

    public ProductResponseByName setGlobalCodeItemNumber(String globalCodeItemNumber) {
        this.globalCodeItemNumber = globalCodeItemNumber;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductResponseByName setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TypeResponseByName getType() {
        return type;
    }

    public ProductResponseByName setType(TypeResponseByName type) {
        this.type = type;
        return this;
    }
}
