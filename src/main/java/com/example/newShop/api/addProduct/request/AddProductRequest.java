package com.example.newShop.api.addProduct.request;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class AddProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String globalCodeItemNumber;

    @NotNull
    @PositiveOrZero
    private BigDecimal price;

    @NonNull
    private TypeRequest type;

    private String promotionName;
    private BigDecimal promotionPrice;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;

    public String getName() {
        return name;
    }

    public AddProductRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getGlobalCodeItemNumber() {
        return globalCodeItemNumber;
    }

    public AddProductRequest setGlobalCodeItemNumber(String globalCodeItemNumber) {
        this.globalCodeItemNumber = globalCodeItemNumber;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddProductRequest setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NonNull
    public TypeRequest getType() {
        return type;
    }

    public AddProductRequest setType(@NonNull TypeRequest type) {
        this.type = type;
        return this;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public AddProductRequest setPromotionName(String promotionName) {
        this.promotionName = promotionName;
        return this;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public AddProductRequest setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
        return this;
    }

    public SimpleDateFormat getStartDate() {
        return startDate;
    }

    public AddProductRequest setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
        return this;
    }

    public SimpleDateFormat getEndDate() {
        return endDate;
    }

    public AddProductRequest setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
        return this;
    }
}
