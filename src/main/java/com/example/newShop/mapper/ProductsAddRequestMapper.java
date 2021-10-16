package com.example.newShop.mapper;

import com.example.newShop.api.addProducts.request.AddProductsRequest;
import com.example.newShop.api.addProducts.request.ProductRequest;
import com.example.newShop.dao.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductsAddRequestMapper {

    public List<Product> mapToProducts(AddProductsRequest request) {
        if (Objects.isNull(request) || Objects.isNull(request.getRequests())) {
            return null;
        }
        return request.getRequests().stream()
                .filter(Objects::nonNull)
//                .map(e->this.toProduct(e))
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

    private Product toProduct(ProductRequest source) {
        if (Objects.isNull(source) || Objects.isNull(source.getGlobalCodeItemNumber())
                || Objects.isNull(source.getName()) || Objects.isNull(source.getType())
                || source.getPrice().compareTo(BigDecimal.ZERO) < 0) {
        return null;
        }
        return new Product()
                .setName(source.getName())
                .setGlobalCodeItemNumber(source.getGlobalCodeItemNumber())
                .setPrice(source.getPrice())
                .setType(source.getType());
    }
}
