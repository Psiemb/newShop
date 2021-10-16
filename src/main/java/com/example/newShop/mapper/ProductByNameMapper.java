package com.example.newShop.mapper;

import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByName.response.TypeResponseByName;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductByNameMapper {

    public ProductResponseByName mapToProductResponseByName(Product source) {
        return new ProductResponseByName()
                .setId(source.getId())
                .setGlobalCodeItemNumber(source.getGlobalCodeItemNumber())
                .setName(source.getName())
                .setPrice(source.getPrice())
                .setType(mapType(source.getType()))
                .setPromotionName(source.getPromotionName())
                .setPromotionPrice(source.getPromotionPrice())
                .setStartDate(source.getStartDate())
                .setEndDate(source.getEndDate());

    }

    private TypeResponseByName mapType(Type source) {
        if (Type.FOOD.equals(source) || Objects.isNull(source)) {
            return TypeResponseByName.FOOD;
        }
        return TypeResponseByName.INDUSTRIAL;
    }

}
