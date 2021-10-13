package com.example.newShop.mapper;

import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.api.findByNumber.response.TypeResponse;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductByNumberMapperTest {

    private final ProductByNumberMapper productByNumberMapper = new ProductByNumberMapper();

    @Test
    void should() {
        //given
        Product product = new Product()
                .setId(2L)
                .setGlobalCodeItemNumber("PPP")
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(Type.INDUSTRIAL);
        //when
        ProductResponseByNumber result = productByNumberMapper.mapToProductResponseByNumber(product);
        //then
        assertEquals(2L, result.getId());
        assertEquals("PPP", result.getGlobalCodeItemNumber());
        assertEquals("Daniel", result.getName());
        assertEquals(new BigDecimal("555.55"), result.getPrice());
        assertEquals(TypeResponse.INDUSTRIAL, result.getType());
    }

}