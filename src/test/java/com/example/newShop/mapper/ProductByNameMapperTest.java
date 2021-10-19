package com.example.newShop.mapper;

import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByName.response.ProductsResponseByName;
import com.example.newShop.api.findByName.response.TypeResponseByName;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Promotion;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductByNameMapperTest {

    private final ProductByNameMapper productByNameMapper = new ProductByNameMapper();

    @Test
    void returnProductResponseByNameWhenProductIsGiven() {
        //given
        Promotion promotion = new Promotion()
                .setName("Promotion")
                .setPrice(new BigDecimal("5000"));
        Product product = new Product()
                .setId(1L)
                .setGlobalCodeItemNumber("PPPP")
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(Type.FOOD)
                .setPromotion(promotion);

        //when
        ProductsResponseByName result = productByNameMapper.mapToProductResponseByName(Collections.singletonList(product));
        //then
        assertEquals(1L, result.getByName().get(0).getId());
        assertEquals("PPPP", result.getByName().get(0).getGlobalCodeItemNumber());
        assertEquals("Daniel", result.getByName().get(0).getName());
        assertEquals(new BigDecimal("555.55"), result.getByName().get(0).getPrice());
        assertEquals(TypeResponseByName.FOOD, result.getByName().get(0).getType());
        assertEquals("Promotion", result.getByName().get(0).getPromotionName());
        assertEquals(new BigDecimal("5000"), result.getByName().get(0).getPromotionPrice());
        assertEquals(new SimpleDateFormat("2021-10-12 01:00"), result.getByName().get(0).getStartDate());
        assertEquals(new SimpleDateFormat("2021-12-24 01:00"), result.getByName().get(0).getEndDate());
    }

    @Test
    void returnProductResponseByNameFieldsEqualNullWhenProductIsGivenFieldsEqualNull() {
        //given
        Promotion promotion = new Promotion()
                .setName(null)
                .setPrice(null)
                .setStartDate(null)
                .setStartDate(null);
        Product product = new Product()
                .setId(1L)
                .setGlobalCodeItemNumber(null)
                .setName(null)
                .setPrice(null)
                .setType(null)
                .setPromotion(promotion);
        //when
        ProductsResponseByName result = productByNameMapper.mapToProductResponseByName(Arrays.asList(product));
        //then
        assertEquals(1L, result.getByName().get(0).getId());
        assertNull(result.getByName().get(0).getGlobalCodeItemNumber());
        assertNull(result.getByName().get(0).getName());
        assertNull(result.getByName().get(0).getPrice());
        assertNull(result.getByName().get(0).getType());
        assertNull(result.getByName().get(0).getPromotionName());
        assertNull(result.getByName().get(0).getPromotionPrice());
        assertNull(result.getByName().get(0).getStartDate());
        assertNull(result.getByName().get(0).getEndDate());
    }

}