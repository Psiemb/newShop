package com.example.newShop.mapper;

import com.example.newShop.api.addProduct.request.TypeRequest;
import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByName.response.TypeResponseByName;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductByNameMapperTest {

    private final ProductByNameMapper productByNameMapper = new ProductByNameMapper();

    @Test
    void returnProductResponseByNameWhenProductIsGiven(){
        //given
        Product product = new Product()
                .setId(1L)
                .setGlobalCodeItemNumber("PPPP")
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(Type.FOOD);
        //when
        ProductResponseByName result = productByNameMapper.mapToProductResponseByName(product);
        //then
        assertEquals(1L, result.getId());
        assertEquals("PPPP", result.getGlobalCodeItemNumber());
        assertEquals("Daniel", result.getName());
        assertEquals(new BigDecimal("555.55"), result.getPrice());
        assertEquals(TypeResponseByName.FOOD, result.getType());
    }
    @Test
    void returnProductResponseByNameFieldsEqualNullWhenProductIsGivenFieldsEqualNull(){
        //given
        Product product = new Product()
                .setId(1L)
                .setGlobalCodeItemNumber(null)
                .setName(null)
                .setPrice(null)
                .setType(null);
        //when
        ProductResponseByName result = productByNameMapper.mapToProductResponseByName(product);
        //then
        assertEquals(1L, result.getId());
        assertNull(result.getGlobalCodeItemNumber());
        assertNull(result.getName());
        assertNull(result.getPrice());
        assertEquals(TypeResponseByName.FOOD, result.getType());
    }

}