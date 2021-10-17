package com.example.newShop.api.findByNumber.response;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class ProductResponseByNumber {

    private Long id;
    private String name;
    private String globalCodeItemNumber;
    private BigDecimal price;
    private TypeResponse type;
    private String promotionName;
    private BigDecimal promotionPrice;
    private SimpleDateFormat promotionStartDate;
    private SimpleDateFormat promotionEndDate;

    public Long getId() {
        return id;
    }

    public ProductResponseByNumber setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponseByNumber setName(String name) {
        this.name = name;
        return this;
    }

    public String getGlobalCodeItemNumber() {
        return globalCodeItemNumber;
    }

    public ProductResponseByNumber setGlobalCodeItemNumber(String globalCodeItemNumber) {
        this.globalCodeItemNumber = globalCodeItemNumber;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductResponseByNumber setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TypeResponse getType() {
        return type;
    }

    public ProductResponseByNumber setType(TypeResponse type) {
        this.type = type;
        return this;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public ProductResponseByNumber setPromotionName(String promotionName) {
        this.promotionName = promotionName;
        return this;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public ProductResponseByNumber setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
        return this;
    }

    public SimpleDateFormat getPromotionStartDate() {
        return promotionStartDate;
    }

    public ProductResponseByNumber setPromotionStartDate(SimpleDateFormat promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
        return this;
    }

    public SimpleDateFormat getPromotionEndDate() {
        return promotionEndDate;
    }

    public ProductResponseByNumber setPromotionEndDate(SimpleDateFormat promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
        return this;
    }
}
