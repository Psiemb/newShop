package com.example.newShop.api.findByName.response;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class ProductResponseByName {

    private Long id;
    private String name;
    private String globalCodeItemNumber;
    private BigDecimal price;
    private TypeResponseByName type;
    private String promotionName;
    private BigDecimal promotionPrice;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;

    public Long getId() {
        return id;
    }

    public ProductResponseByName setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseByName setName(String name) {
        this.name = name;
        return this;
    }

    public String getGlobalCodeItemNumber() {
        return globalCodeItemNumber;
    }

    public ProductResponseByName setGlobalCodeItemNumber(String globalCodeItemNumber) {
        this.globalCodeItemNumber = globalCodeItemNumber;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductResponseByName setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TypeResponseByName getType() {
        return type;
    }

    public ProductResponseByName setType(TypeResponseByName type) {
        this.type = type;
        return this;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public ProductResponseByName setPromotionName(String promotionName) {
        this.promotionName = promotionName;
        return this;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public ProductResponseByName setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
        return this;
    }

    public SimpleDateFormat getStartDate() {
        return startDate;
    }

    public ProductResponseByName setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
        return this;
    }

    public SimpleDateFormat getEndDate() {
        return endDate;
    }

    public ProductResponseByName setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
        return this;
    }
}
