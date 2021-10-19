package com.example.newShop.mapper;

import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByName.response.ProductsResponseByName;
import com.example.newShop.api.findByName.response.TypeResponseByName;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Promotion;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductByNameMapper {

    public ProductsResponseByName mapToProductResponseByName(List<Product> source) {

        List<ProductResponseByName> collect = Optional.ofNullable(source)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(this::toProductResponse)
                .collect(Collectors.toList());

        ProductsResponseByName productsResponseByName = new ProductsResponseByName();
        productsResponseByName.setByName(collect);
        return productsResponseByName;
    }

    private ProductResponseByName toProductResponse(Product product) {
        if (Objects.isNull(product)) {
            return null;
        }

        return new ProductResponseByName()
                .setId(product.getId())
                .setGlobalCodeItemNumber(product.getGlobalCodeItemNumber())
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setType(mapType(product.getType()))
//                .setPromotion(toPromotion(product.getPromotion()));
                .setPromotionName(totName(product.getPromotion()))
                .setPromotionPrice(toPrice(product.getPromotion()))
                .setStartDate(toStartDate(product.getPromotion()))
                .setEndDate(toEndDate(product.getPromotion()));
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

    private String totName(Promotion promotion) {
        if (Objects.isNull(promotion)) {
            return null;
        }
        return promotion.getName();
    }


    private TypeResponseByName mapType(Type source) {
        if (Type.FOOD.equals(source) || Objects.isNull(source)) {
            return TypeResponseByName.FOOD;
        }
        return TypeResponseByName.INDUSTRIAL;
    }

}
