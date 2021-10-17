package com.example.newShop.api.addProduct.request;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

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

   private PromotionRequest promotionRequest;

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

    public PromotionRequest getPromotionRequest() {
        return promotionRequest;
    }

    public AddProductRequest setPromotionRequest(PromotionRequest promotionRequest) {
        this.promotionRequest = promotionRequest;
        return this;
    }
}
