package com.example.newShop.mapper;

import com.example.newShop.api.addProducts.request.AddProductsRequest;
import com.example.newShop.api.addProducts.request.ProductRequest;
import com.example.newShop.api.addProducts.request.Promotion;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
//        List<Promotion> promotions = Arrays.asList(new Promotion()
//                        .setName("Promotion")
//                        .setPrice(new BigDecimal("500"))
//                        .setStartDate(new SimpleDateFormat("2021-10-12 01:00"))
//                        .setStartDate(new SimpleDateFormat("2021-12-24 01:00")),
//                new Promotion()
//                        .setName("PPromotion")
//                        .setPrice(new BigDecimal("450"))
//                        .setStartDate(new SimpleDateFormat("2021-11-12 01:00"))
//                        .setStartDate(new SimpleDateFormat("2021-12-20 01:00")));
        List<ProductRequest> productRequests = Arrays.asList(new ProductRequest()
                        .setGlobalCodeItemNumber("WWWW")
                        .setName("AAAA")
                        .setPrice(new BigDecimal("3233.2"))
                        .setType(Type.FOOD)
                        .setPromotion(new Promotion()
                                .setName("Promotion")
                                .setPrice(new BigDecimal("500"))
                                .setStartDate(new SimpleDateFormat("2021-10-12 01:00"))
                                .setStartDate(new SimpleDateFormat("2021-12-24 01:00"))),
                new ProductRequest()
                        .setGlobalCodeItemNumber("QQQQ")
                        .setName("BBBB")
                        .setPrice(new BigDecimal("1111.1"))
                        .setType(Type.FOOD)
                        .setPromotion(new Promotion()
                                .setName("PPromotion")
                                .setPrice(new BigDecimal("450"))
                                .setStartDate(new SimpleDateFormat("2021-11-12 01:00"))
                                .setStartDate(new SimpleDateFormat("2021-12-20 01:00"))));

        AddProductsRequest addProductsRequest = new AddProductsRequest()
                .setProducts(productRequests);
        //when
        List<Product> result = productsAddRequestMapper.mapToProducts(addProductsRequest);
        //then
        assertEquals(productRequests.get(0).getGlobalCodeItemNumber(), result.get(0).getGlobalCodeItemNumber());
        assertEquals(productRequests.get(1).getGlobalCodeItemNumber(), result.get(1).getGlobalCodeItemNumber());
        assertEquals(productRequests.get(1).getName(), result.get(1).getName());
        assertEquals(productRequests.get(0).getName(), result.get(0).getName());
        assertEquals(productRequests.get(0).getPrice(), result.get(0).getPrice());
        assertEquals(productRequests.get(1).getPrice(), result.get(1).getPrice());
        assertEquals(productRequests.get(0).getType(), result.get(0).getType());
        assertEquals(productRequests.get(1).getType(), result.get(1).getType());
        assertEquals(productRequests.get(0).getPromotion().getName(), result.get(0).getPromotion().getName());
        assertEquals(productRequests.get(1).getPromotion().getName(), result.get(1).getPromotion().getName());
        assertEquals(productRequests.get(0).getPromotion().getPrice(), result.get(0).getPromotion().getPrice());
        assertEquals(productRequests.get(1).getPromotion().getPrice(), result.get(1).getPromotion().getPrice());
        assertEquals(productRequests.get(0).getPromotion().getStartDate(), result.get(0).getPromotion().getStartDate());
        assertEquals(productRequests.get(1).getPromotion().getStartDate(), result.get(1).getPromotion().getStartDate());
        assertEquals(productRequests.get(0).getPromotion().getEndDate(), result.get(0).getPromotion().getEndDate());
        assertEquals(productRequests.get(1).getPromotion().getEndDate(), result.get(1).getPromotion().getEndDate());

//        assertEquals(productRequests.stream().map(ProductRequest::getGlobalCodeItemNumber), result.stream().map(Product::getGlobalCodeItemNumber));
    }

    @Test
    void shouldReturnNullWhenGlobalCodeItemNumberIsNull() {
        //given
        List<ProductRequest> productRequests = Collections.singletonList(new ProductRequest()
                .setGlobalCodeItemNumber(null)
                .setName("AAAA")
                .setPrice(new BigDecimal("323.45"))
                .setType(Type.FOOD)
                .setPromotion(new Promotion()
                        .setName("Promotion")
                        .setPrice(new BigDecimal("500"))
                        .setStartDate(new SimpleDateFormat("2021-10-12 01:00"))
                        .setStartDate(new SimpleDateFormat("2021-12-24 01:00"))));

        AddProductsRequest addProductsRequest = new AddProductsRequest()
                .setProducts(productRequests);
        //when
        List<Product> result = productsAddRequestMapper.mapToProducts(addProductsRequest);
        //then
        assertNull(result.get(0).getGlobalCodeItemNumber());
        assertEquals("AAAA", result.get(0).getName());
    }
//    @Test
//    void shouldReturnNullWhenPriceOfProductIsMinus(){
//        //given
//        List<ProductRequest> productRequests = Collections.singletonList(new ProductRequest()
//                .setGlobalCodeItemNumber("WWW")
//                .setName("AAAA")
//                .setPrice(new BigDecimal("-323.45"))
//                .setType(Type.FOOD));
//        AddProductsRequest addProductsRequest = new AddProductsRequest()
//                .setRequests(productRequests);
//        //when
//        List<Product> result = productsAddRequestMapper.mapToProducts(addProductsRequest);
//        //then
//        assertNull(result.get(0));
//    }
}