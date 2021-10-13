package com.example.newShop.mapper;

import com.example.newShop.api.addProduct.request.AddProductRequest;
import com.example.newShop.api.addProduct.request.TypeRequest;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductAddRequestMapperTest {

    private final ProductAddRequestMapper productAddRequestMapper = new ProductAddRequestMapper();

    @Test
    void shouldReturnProductWhenProductRequestISGiven() {
        //given
        AddProductRequest addProductRequest = new AddProductRequest()
                .setGlobalCodeItemNumber("PPPP")
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(TypeRequest.FOOD);
        //when
        Product result = productAddRequestMapper.mapToProduct(addProductRequest);
        //then
        assertEquals("PPPP", result.getGlobalCodeItemNumber());
        assertEquals("Daniel", result.getName());
        assertEquals(new BigDecimal("555.55"), result.getPrice());
        assertEquals(Type.FOOD, result.getType());
    }
    @Test
    void shouldReturnNullWhenGlobalCodeItemNumberIsNull() {
        //given
        AddProductRequest addProductRequest = new AddProductRequest()
                .setGlobalCodeItemNumber(null)
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(TypeRequest.FOOD);
        //when
        Product result = productAddRequestMapper.mapToProduct(addProductRequest);
        //then
        assertNull(result);
    }

}