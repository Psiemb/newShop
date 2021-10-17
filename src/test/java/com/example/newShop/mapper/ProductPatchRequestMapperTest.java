package com.example.newShop.mapper;

import com.example.newShop.api.patchProduct.request.PatchProductRequest;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

class ProductPatchRequestMapperTest {

    private final ProductPatchRequestMapper productPatchRequestMapper = new ProductPatchRequestMapper();

    @Test
    void shouldReturnProductWhenPatchPromotionRequestIsGiven() {
        //given
        PatchProductRequest promotion = new PatchProductRequest()
                .setPromotionName("Promotion")
                .setPromotionPrice(new BigDecimal("500"))
                .setStartDate(new SimpleDateFormat("2021-10-12 01:00"))
                .setStartDate(new SimpleDateFormat("2021-12-24 01:00"));
        //when
        Product product = productPatchRequestMapper.mapToProduct(promotion);
        //then
        Assertions.assertEquals(product.getPromotionName(), product.getPromotionName());
        Assertions.assertEquals(product.getPromotionPrice(), product.getPromotionPrice());
        Assertions.assertEquals(product.getStartDate(), product.getStartDate());
        Assertions.assertEquals(product.getEndDate(), product.getEndDate());
    }

    @Test
    void shouldReturnNullWhenPatchPromotionRequestNameIsNull() {
        //given
        PatchProductRequest promotion = new PatchProductRequest()
                .setPromotionName(null)
                .setPromotionPrice(new BigDecimal("500"))
                .setStartDate(new SimpleDateFormat("2021-10-12 01:00"))
                .setStartDate(new SimpleDateFormat("2021-12-24 01:00"));
        //when
        Product product = productPatchRequestMapper.mapToProduct(promotion);
        //then
        Assertions.assertNull(product.getPromotionName());
    }

    @Test
    void shouldReturnProductWhenProduct1AndProduct2IsGiven() {
        //given
        Product product1 = new Product()
                .setName("AAAAA")
                .setPrice(new BigDecimal("1000"))
                .setGlobalCodeItemNumber("QQQQQ")
                .setType(Type.FOOD);
        Product product2 = new Product()
                .setPromotionName("Promotion")
                .setPromotionPrice(new BigDecimal("500"))
                .setStartDate(new SimpleDateFormat("2021-10-12 01:00"))
                .setStartDate(new SimpleDateFormat("2021-12-24 01:00"));
        //when
        Product product = productPatchRequestMapper.mapToUpdatedProduct(product1, product2);
        //then
        Assertions.assertEquals(product1.getName(), product.getName());
        Assertions.assertEquals(product1.getPrice(), product.getPrice());
        Assertions.assertEquals(product1.getGlobalCodeItemNumber(), product.getGlobalCodeItemNumber());
        Assertions.assertEquals(product1.getType(), product.getType());
        Assertions.assertEquals(product2.getPromotionName(), product.getPromotionName());
        Assertions.assertEquals(product2.getPromotionPrice(), product.getPromotionPrice());
        Assertions.assertEquals(product2.getStartDate(), product.getStartDate());
        Assertions.assertEquals(product2.getEndDate(), product.getEndDate());
    }

}