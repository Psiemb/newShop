package com.example.newShop.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
//@Table(name = "promocje")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Promotion)) return false;
        Promotion promotion = (Promotion) o;
        return Objects.equals(id, promotion.id) &&
                Objects.equals(name, promotion.name) &&
                Objects.equals(price, promotion.price) &&
                Objects.equals(startDate, promotion.startDate) &&
                Objects.equals(endDate, promotion.endDate) &&
                Objects.equals(product, promotion.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, startDate, endDate, product);
    }
}
