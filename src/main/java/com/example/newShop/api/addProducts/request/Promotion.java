package com.example.newShop.api.addProducts.request;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class Promotion {
    private String Name;
    private BigDecimal Price;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;

    public String getName() {
        return Name;
    }

    public Promotion setName(String name) {
        Name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public Promotion setPrice(BigDecimal price) {
        Price = price;
        return this;
    }

    public SimpleDateFormat getStartDate() {
        return startDate;
    }

    public Promotion setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
        return this;
    }

    public SimpleDateFormat getEndDate() {
        return endDate;
    }

    public Promotion setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
        return this;
    }
}
