package com.example.newShop.mapper;

import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByName.response.TypeResponseByName;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Promotion;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductByNameMapperTest {

    private final ProductByNameMapper productByNameMapper = new ProductByNameMapper();

    @Test
    void returnProductResponseByNameWhenProductIsGiven() {
        //given
        Promotion promotion = new Promotion()
                .setName("Promotion")
                .setPrice(new BigDecimal("5000"))
                .setStartDate(new SimpleDateFormat("2021-10-12 01:00"))
                .setEndDate(new SimpleDateFormat("2021-12-24 01:00"));
        Product product = new Product()
                .setId(1L)
                .setGlobalCodeItemNumber("PPPP")
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(Type.FOOD)
                .setPromotion(promotion);

        //when
        ProductResponseByName result = productByNameMapper.mapToProductResponseByName(product);
        //then
        assertEquals(1L, result.getId());
        assertEquals("PPPP", result.getGlobalCodeItemNumber());
        assertEquals("Daniel", result.getName());
        assertEquals(new BigDecimal("555.55"), result.getPrice());
        assertEquals(TypeResponseByName.FOOD, result.getType());
        assertEquals("Promotion", result.getPromotionName());
        assertEquals(new BigDecimal("5000"), result.getPromotionPrice());
        assertEquals(new SimpleDateFormat("2021-10-12 01:00"), result.getStartDate());
        assertEquals(new SimpleDateFormat("2021-12-24 01:00"), result.getEndDate());
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
        ProductResponseByName result = productByNameMapper.mapToProductResponseByName(product);
        //then
        assertEquals(1L, result.getId());
        assertNull(result.getGlobalCodeItemNumber());
        assertNull(result.getName());
        assertNull(result.getPrice());
        assertNull(result.getType());
        assertNull(result.getPromotionName());
        assertNull(result.getPromotionPrice());
        assertNull(result.getStartDate());
        assertNull(result.getEndDate());
    }

}