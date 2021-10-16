package com.example.newShop.mapper;

import com.example.newShop.api.addProducts.request.AddProductsRequest;
import com.example.newShop.api.addProducts.request.ProductRequest;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProductsAddRequestMapperTest {

    private final ProductsAddRequestMapper productsAddRequestMapper = new ProductsAddRequestMapper();

    @Test
    void shouldReturnProductListWhenRequestListIsGiven() {
        //given
        List<ProductRequest> productRequests = Arrays.asList(new ProductRequest()
                        .setGlobalCodeItemNumber("WWWW")
                        .setName("AAAA")
                        .setPrice(new BigDecimal("3233.2"))
                        .setType(Type.FOOD),
                new ProductRequest()
                        .setGlobalCodeItemNumber("QQQQ")
                        .setName("BBBB")
                        .setPrice(new BigDecimal("1111.1"))
                        .setType(Type.FOOD));
        AddProductsRequest addProductsRequest = new AddProductsRequest()
                .setRequests(productRequests);
        //when
        List<Product> result = productsAddRequestMapper.mapToProducts(addProductsRequest);
        //then
        assertEquals(productRequests.get(0).getGlobalCodeItemNumber(), result.get(0).getGlobalCodeItemNumber());
        assertEquals(productRequests.get(1).getGlobalCodeItemNumber(), result.get(1).getGlobalCodeItemNumber());
//        assertEquals(productRequests.stream().map(ProductRequest::getGlobalCodeItemNumber), result.stream().map(Product::getGlobalCodeItemNumber));
    }
    @Test
    void shouldReturnNullWhenGlobalCodeItemNumberIsNull(){
        //given
        List<ProductRequest> productRequests = Collections.singletonList(new ProductRequest()
                .setGlobalCodeItemNumber(null)
                .setName("AAAA")
                .setPrice(new BigDecimal("3233.2"))
                .setType(Type.FOOD));
        AddProductsRequest addProductsRequest = new AddProductsRequest()
                .setRequests(productRequests);
        //when
        List<Product> result = productsAddRequestMapper.mapToProducts(addProductsRequest);
        //then
        assertNull(result.get(0).getGlobalCodeItemNumber());
    }
}