package com.example.newShop.mapper;

import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.api.findByNumber.response.TypeResponse;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Promotion;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@Component
public class ProductByNumberMapper {

    public ProductResponseByNumber mapToProductResponseByNumber(Product product) {
//        ObjectUtils.allNotNull(product.getGlobalCodeItemNumber(),product.getName() )   Chyba zbędnę bo się zabezpieczam przy Request za pomocą np: @NotNull
        if (Objects.isNull(product)) {
            return null;
        }
        return new ProductResponseByNumber()
                .setId(product.getId())
                .setGlobalCodeItemNumber(product.getGlobalCodeItemNumber())
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setType(toType(product.getType()))
                .setPromotionName(toName(product.getPromotion()))
                .setPromotionPrice(toPrice(product.getPromotion()))
                .setPromotionStartDate(toStartDate(product.getPromotion()))
                .setPromotionEndDate(toEndDate(product.getPromotion()));
    }

    private OffsetDateTime toEndDate(Promotion promotion) {
        if (Objects.isNull(promotion)) {
            return null;
        }
        return promotion.getEndDate();
    }

    private OffsetDateTime toStartDate(Promotion promotion) {
        if (Objects.isNull(promotion)) {
            return null;
        }
        return promotion.getStartDate();
    }

    private BigDecimal toPrice(Promotion promotion) {
        if (Objects.isNull(promotion)) {
            return null;
        }
        return promotion.getPrice();
    }

    private String toName(Promotion promotion) {
        if (Objects.isNull(promotion)) {
            return null;
        }
        return promotion.getName();
    }

    private TypeResponse toType(Type source) {
        if (Objects.isNull(source)) {
            return null;
        }
//        if (Type.FOOD.equals(source) || Objects.isNull(source)) {
//            return TypeResponse.FOOD;
//        }
//        return TypeResponse.INDUSTRIAL;
        return TypeResponse.valueOf(source.name());
    }
}
