package com.example.newShop.api.addProducts.request;

import com.example.newShop.dao.entity.Type;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class ProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String globalCodeItemNumber;

    @PositiveOrZero
    private BigDecimal price;

    @NotNull
    private Type type;

    @NotNull
    private Promotion promotion;

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

    public Promotion getPromotion() {
        return promotion;
    }

    public ProductRequest setPromotion(Promotion promotion) {
        this.promotion = promotion;
        return this;
    }
}
