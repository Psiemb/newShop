package com.example.newShop.api.findByNumber.response;

import com.example.newShop.api.addProduct.request.TypeRequest;
import java.math.BigDecimal;

public class ProductResponseByNumber {

    private Long id;
    private String name;
    private String globalCodeItemNumber;
    private BigDecimal price;
    private TypeResponse type;

    public Long getId() {
        return id;
    }

    public ProductResponseByNumber setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseByNumber setName(String name) {
        this.name = name;
        return this;
    }

    public String getGlobalCodeItemNumber() {
        return globalCodeItemNumber;
    }

    public ProductResponseByNumber setGlobalCodeItemNumber(String globalCodeItemNumber) {
        this.globalCodeItemNumber = globalCodeItemNumber;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductResponseByNumber setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TypeResponse getType() {
        return type;
    }

    public ProductResponseByNumber setType(TypeResponse type) {
        this.type = type;
        return this;
    }
}
