package com.example.newShop.mapper;

import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.api.findByNumber.response.TypeResponse;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProductByNumberMapperToTypeTest {

    private final ProductByNumberMapper productByNumberMapper = new ProductByNumberMapper();

    @Test
    void shouldReturnTypeResponseFoodWhenTypeFoodIsGiven(){
        //given
        Product product = createProduct(Type.FOOD);
        //when
        ProductResponseByNumber result = productByNumberMapper.mapToProductResponseByNumber(product);
        //then
        assertEquals(TypeResponse.FOOD, result.getType());
    }

    private Product createProduct(Type type) {
        if(Objects.isNull(type)){
            return null;
        }
        return new Product()
                .setType(type);
    }

    @Test
    void shouldReturnTypeResponseIndustrialWhenTypeIndustrialIsGiven(){
        //given
        Product product = createProduct(Type.INDUSTRIAL);
//        Product product = new Product()
//                .setType(Type.INDUSTRIAL);
        //when
        ProductResponseByNumber result = productByNumberMapper.mapToProductResponseByNumber(product);
        //then
        assertEquals(TypeResponse.INDUSTRIAL, result.getType());
    }
}