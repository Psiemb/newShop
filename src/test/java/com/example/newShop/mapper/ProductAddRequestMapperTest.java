package com.example.newShop.mapper;

import com.example.newShop.api.addProduct.request.AddProductRequest;
import com.example.newShop.api.addProduct.request.PromotionRequest;
import com.example.newShop.api.addProduct.request.TypeRequest;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductAddRequestMapperTest {

    private final ProductAddRequestMapper productAddRequestMapper = new ProductAddRequestMapper();

    @Test
    void shouldReturnProductWhenProductRequestISGiven() {
        //given
        PromotionRequest promotion = new PromotionRequest()
                .setName("Promotion")
                .setPrice(new BigDecimal("500"))
                .setStartDate(OffsetDateTime.now())
                .setEndDate(OffsetDateTime.now().plusDays(2));

        AddProductRequest addProductRequest = new AddProductRequest()
                .setGlobalCodeItemNumber("PPPP")
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(TypeRequest.FOOD)
                .setPromotionRequest(promotion);
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
        PromotionRequest promotion = new PromotionRequest()
                .setName("Promotion")
                .setPrice(new BigDecimal("500"))
                .setStartDate(OffsetDateTime.now())
                .setEndDate(OffsetDateTime.now().plusDays(2));

        AddProductRequest addProductRequest = new AddProductRequest()
                .setGlobalCodeItemNumber(null)
                .setName("Daniel")
                .setPrice(new BigDecimal("555.55"))
                .setType(TypeRequest.FOOD)
                .setPromotionRequest(promotion);
        //when
        Product result = productAddRequestMapper.mapToProduct(addProductRequest);
        //then
        assertNull(result.getGlobalCodeItemNumber());
    }

}