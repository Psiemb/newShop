package com.example.newShop.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "Produkty")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String globalCodeItemNumber;
    private BigDecimal price;
    private Type type;
    private String promotionName;
    private BigDecimal promotionPrice;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getGlobalCodeItemNumber() {
        return globalCodeItemNumber;
    }

    public Product setGlobalCodeItemNumber(String globalCodeItemNumber) {
        this.globalCodeItemNumber = globalCodeItemNumber;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Product setType(Type type) {
        this.type = type;
        return this;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public Product setPromotionName(String promotionName) {
        this.promotionName = promotionName;
        return this;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public Product setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
        return this;
    }

    public SimpleDateFormat getStartDate() {
        return startDate;
    }

    public Product setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
        return this;
    }

    public SimpleDateFormat getEndDate() {
        return endDate;
    }

    public Product setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
        return this;
    }
}