package com.example.newShop.api.patchProduct.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class PatchPromotionRequest {

    @NotBlank
    private String productName;

    @NotBlank
    private String promotionName;

    @PositiveOrZero
    private BigDecimal promotionPrice;

    @NotBlank
    private SimpleDateFormat startDate;

    @NotBlank
    private SimpleDateFormat endDate;

    public String getProductName() {
        return productName;
    }

    public PatchPromotionRequest setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public PatchPromotionRequest setPromotionName(String promotionName) {
        this.promotionName = promotionName;
        return this;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public PatchPromotionRequest setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
        return this;
    }

    public SimpleDateFormat getStartDate() {
        return startDate;
    }

    public PatchPromotionRequest setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
        return this;
    }

    public SimpleDateFormat getEndDate() {
        return endDate;
    }

    public PatchPromotionRequest setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
        return this;
    }
}
