package com.example.newShop.api.addProduct.request;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class PromotionRequest {

    private String name;
    private BigDecimal price;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;

    public String getName() {
        return name;
    }

    public PromotionRequest setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PromotionRequest setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public SimpleDateFormat getStartDate() {
        return startDate;
    }

    public PromotionRequest setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
        return this;
    }

    public SimpleDateFormat getEndDate() {
        return endDate;
    }

    public PromotionRequest setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
        return this;
    }
}
