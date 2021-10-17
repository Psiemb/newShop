package com.example.newShop.mapper;

import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.api.findByNumber.response.TypeResponse;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Promotion;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductByNumberMapperTest {

    private final ProductByNumberMapper productByNumberMapper = new ProductByNumberMapper();

    @Test
    void shouldReturnProductResultByNumberWhenProductIsGiven() {
        //given
        Promotion promotion = new Promotion()
                .setName("Promotion")
                .setPrice(new BigDecimal("5000"))
                .setStartDate(new SimpleDateFormat("2021-10-12 01:00"))
                .setEndDate(new SimpleDateFormat("2021-12-24 01:00"));
        Product product = new Product()
                .setId(2L)
                .setGlobalCodeItemNumber("PPP")
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(Type.INDUSTRIAL)
                .setPromotion(promotion);
        //when
        ProductResponseByNumber result = productByNumberMapper.mapToProductResponseByNumber(product);
        //then
        assertEquals(2L, result.getId());
        assertEquals("PPP", result.getGlobalCodeItemNumber());
        assertEquals("Daniel", result.getName());
        assertEquals(new BigDecimal("555.55"), result.getPrice());
        assertEquals(TypeResponse.INDUSTRIAL, result.getType());
        assertEquals("Promotion", result.getPromotionName());
        assertEquals(new BigDecimal("5000"), result.getPromotionPrice());
        assertEquals(new SimpleDateFormat("2021-10-12 01:00"), result.getPromotionStartDate());
        assertEquals(new SimpleDateFormat("2021-12-24 01:00"), result.getPromotionEndDate());
    }

}