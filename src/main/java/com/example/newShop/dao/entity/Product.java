package com.example.newShop.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produkty")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String globalCodeItemNumber;
    private BigDecimal price;
    private Type type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "promotion_id", referencedColumnName = "id")
    private Promotion promotion;

    public Product() {
    }

    public Product(Long id, String name, String globalCodeItemNumber, BigDecimal price, Type type, Promotion promotion) {
        this.id = id;
        this.name = name;
        this.globalCodeItemNumber = globalCodeItemNumber;
        this.price = price;
        this.type = type;
        this.promotion = promotion;
    }

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

    public Promotion getPromotion() {
        return promotion;
    }

    public Product setPromotion(Promotion promotion) {
        this.promotion = promotion;
        return this;
    }
}