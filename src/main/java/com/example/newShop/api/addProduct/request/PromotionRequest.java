package com.example.newShop.api.addProduct.request;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class PromotionRequest {

    private String name;
    private BigDecimal price;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

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

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public PromotionRequest setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public PromotionRequest setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }
}
