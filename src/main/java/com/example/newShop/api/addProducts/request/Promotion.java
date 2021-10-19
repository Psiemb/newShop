package com.example.newShop.api.addProducts.request;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Promotion {

    private String name;
    private BigDecimal price;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

    public String getName() {
        return name;
    }

    public Promotion setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Promotion setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public Promotion setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public Promotion setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }
}
