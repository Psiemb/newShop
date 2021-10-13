package com.example.newShop.mapper;

import com.example.newShop.api.findByNumber.request.ProductByNumber;
import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.api.findByNumber.response.TypeResponse;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductByNumberMapper {

    public Product mapToProduct(ProductByNumber source) {
        if (Objects.isNull(source) || Objects.isNull(source.getGlobalCodeItemNumber())) {
            return null;
        }
        Product product = new Product();
        product.setGlobalCodeItemNumber(source.getGlobalCodeItemNumber());
        return product;
    }

    public ProductResponseByNumber mapToProductResponseByNumber(Product product) {
//        ObjectUtils.allNotNull(product.getGlobalCodeItemNumber(),product.getName() )
        if (Objects.isNull(product)) {
            return null;
        }
        return new ProductResponseByNumber()
                .setGlobalCodeItemNumber(product.getGlobalCodeItemNumber())
                .setName(product.getName())
                .setPrice(product.getPrice())
                .setType(toType(product.getType()));
    }

    private TypeResponse toType(Type source) {

//        TypeResponse typeResponse = TypeResponse.valueOf(source.name());

        if (Type.FOOD.equals(source)) {
                return TypeResponse.FOOD;
            }
            return TypeResponse.INDUSTRIAL;
        }
    }
