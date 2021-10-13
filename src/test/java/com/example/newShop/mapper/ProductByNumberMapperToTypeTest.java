package com.example.newShop.mapper;

import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.api.findByNumber.response.TypeResponse;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductByNumberMapperToTypeTest {

    private final ProductByNumberMapper productByNumberMapper = new ProductByNumberMapper();

    @Test
    void shouldReturnTypeResponseFoodWhenTypeFoodIsGiven(){
        //given
        Product product = new Product()
                .setType(Type.FOOD);
        //when
        ProductResponseByNumber result = productByNumberMapper.mapToProductResponseByNumber(product);
        //then
        assertEquals(TypeResponse.FOOD, result.getType());
    }
    @Test
    void shouldReturnTypeResponseIndustrialWhenTypeIndustrialIsGiven(){
        //given
        Product product = new Product()
                .setType(Type.INDUSTRIAL);
        //when
        ProductResponseByNumber result = productByNumberMapper.mapToProductResponseByNumber(product);
        //then
        assertEquals(TypeResponse.INDUSTRIAL, result.getType());
    }
}