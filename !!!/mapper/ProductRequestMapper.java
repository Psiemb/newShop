package com.example.newShop.mapper;

import com.example.newShop.api.addProduct.request.AddProductRequest;
import com.example.newShop.api.addProduct.request.TypeRequest;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductRequestMapper {

    public Product mapToProduct(AddProductRequest request) {
        if (Objects.isNull(request) || Objects.isNull(request.getType())
                || Objects.isNull(request.getGlobalCodeItemNumber()) || Objects.isNull(request.getName())
                || Objects.isNull(request.getPrice())) {
            return null;
        }

        Product product = new Product();
        product.setGlobalCodeItemNumber(request.getGlobalCodeItemNumber());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setType(mapType(request.getType()));
        return product;
    }

    private Type mapType(TypeRequest source) {
        if (TypeRequest.FOOD.equals(source)) {
            return Type.FOOD;
        }
        return Type.INDUSTRIAL;
    }
}
