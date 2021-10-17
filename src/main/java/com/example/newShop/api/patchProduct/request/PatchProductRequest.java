package com.example.newShop.api.patchProduct.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class PatchProductRequest {

    @NotBlank
    private String promotionName;

    @PositiveOrZero
    private BigDecimal promotionPrice;

    @NotBlank
    private SimpleDateFormat startDate;

    @NotBlank
    private SimpleDateFormat endDate;

    public String getPromotionName() {
        return promotionName;
    }

    public PatchProductRequest setPromotionName(String promotionName) {
        this.promotionName = promotionName;
        return this;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public PatchProductRequest setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
        return this;
    }

    public SimpleDateFormat getStartDate() {
        return startDate;
    }

    public PatchProductRequest setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
        return this;
    }

    public SimpleDateFormat getEndDate() {
        return endDate;
    }

    public PatchProductRequest setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
        return this;
    }
}
