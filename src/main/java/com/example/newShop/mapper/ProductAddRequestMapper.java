package com.example.newShop.mapper;

import com.example.newShop.api.addProduct.request.AddProductRequest;
import com.example.newShop.api.addProduct.request.TypeRequest;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductAddRequestMapper {

    public Product mapToProduct(AddProductRequest request) {
        if (Objects.isNull(request) || Objects.isNull(request.getGlobalCodeItemNumber()) || Objects.isNull(request.getName()) || Objects.isNull(request.getPrice())) {
            return null;
        }

        return new Product()
                .setGlobalCodeItemNumber(request.getGlobalCodeItemNumber())
                .setName(request.getName())
                .setPrice(request.getPrice())
                .setType(mapType(request.getType()))
                .setPromotionName(request.getPromotionName())
                .setPromotionPrice(request.getPromotionPrice())
                .setStartDate(request.getStartDate())
                .setEndDate(request.getEndDate());

    }

    private Type mapType(TypeRequest source) {
        if (TypeRequest.FOOD.equals(source)) {
            return Type.FOOD;
        }
        return Type.INDUSTRIAL;
    }
}
