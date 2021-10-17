package com.example.newShop.mapper;

import com.example.newShop.api.addProducts.request.AddProductsRequest;
import com.example.newShop.api.addProducts.request.ProductRequest;
import com.example.newShop.dao.entity.Product;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductsAddRequestMapper {

    public List<Product> mapToProducts(AddProductsRequest request) {
        if (Objects.isNull(request)) {
            return null;
        }
        return Optional.ofNullable(request.getProducts()).orElse(new ArrayList<>()).stream()
                .filter(Objects::nonNull)
                .map(this::toProduct)
                .collect(Collectors.toList());
    }

    private Product toProduct(@NotNull ProductRequest source) {
        return new Product()
                .setName(source.getName())
                .setGlobalCodeItemNumber(source.getGlobalCodeItemNumber())
                .setPrice(source.getPrice())
                .setType(source.getType())
                .setPromotionName(source.getPromotionName())
                .setPromotionPrice(source.getPromotionPrice())
                .setStartDate(source.getStartDate())
                .setEndDate(source.getEndDate());
    }
}
