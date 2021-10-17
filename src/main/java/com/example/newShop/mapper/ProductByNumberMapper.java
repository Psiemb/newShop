package com.example.newShop.mapper;

import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.api.findByNumber.response.TypeResponse;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Promotion;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductByNumberMapper {

    public ProductResponseByNumber mapToProductResponseByNumber(Product product) {
//        ObjectUtils.allNotNull(product.getGlobalCodeItemNumber(),product.getName() )   Chyba zbędnę bo się zabezpieczam przy Request za pomocą np: @NotNull
        if (Objects.isNull(product) || Objects.isNull(product.getPromotion())) {
            return null;
        }
        return new ProductResponseByNumber()
                .setId(product.getId())
                .setGlobalCodeItemNumber(product.getGlobalCodeItemNumber())
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setType(toType(product.getType()))
                .setPromotionName(product.getPromotion().getName())
                .setPromotionPrice(product.getPromotion().getPrice())
                .setPromotionStartDate(product.getPromotion().getStartDate())
                .setPromotionEndDate(product.getPromotion().getEndDate());
    }

    private TypeResponse toType(Type source) {
//        if (Type.FOOD.equals(source) || Objects.isNull(source)) {
//            return TypeResponse.FOOD;
//        }
//        return TypeResponse.INDUSTRIAL;
        return TypeResponse.valueOf(source.name());
    }
}
