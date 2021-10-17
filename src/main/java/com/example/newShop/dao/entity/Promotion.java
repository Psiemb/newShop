package com.example.newShop.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "promocje")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;

    @OneToOne(mappedBy = "promotion")
    private Product product;

    public Promotion() {
    }

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
