package com.example.newShop.controller;

import com.example.newShop.api.addProduct.request.AddProductRequest;
import com.example.newShop.api.findByName.request.ProductByName;
import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.manager.ProductManager;
import com.example.newShop.mapper.ProductByNameMapper;
import com.example.newShop.mapper.ProductByNumberMapper;
import com.example.newShop.mapper.ProductRequestMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductManager productManager;
    private final ProductRequestMapper productRequestMapper;
    private final ProductByNumberMapper productByNumberMapper;
    private final ProductByNameMapper productByNameMapper;

    public ProductController(ProductManager productManager, ProductRequestMapper productRequestMapper, ProductByNumberMapper productByNumberMapper, ProductByNameMapper productByNameMapper) {
        this.productManager = productManager;
        this.productRequestMapper = productRequestMapper;
        this.productByNumberMapper = productByNumberMapper;
        this.productByNameMapper = productByNameMapper;
    }

    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody @Valid AddProductRequest request) {
//////        if (Objects.isNull(request) || Objects.isNull(request.getPriceRequest())
////                || Objects.isNull(request.getNameRequest()) || Objects.isNull(request.getGlobalCodeItemNumberRequest())
////                || Objects.isNull(request.getTypeRequest())) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
        Product product = productRequestMapper.mapToProduct(request);
        productManager.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/products/{productGCIN}")
    public ResponseEntity<ProductResponseByNumber> getByGlobalCodeItemNumber(@PathVariable(name = "productGCIN") String gcin) {
        if (StringUtils.isBlank(gcin)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Optional<Product> byGlobalCodeItemNumber = productManager.findByGlobalCodeItemNumber(gcin);
        if (byGlobalCodeItemNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ProductResponseByNumber response = productByNumberMapper.mapToProductResponseByNumber(byGlobalCodeItemNumber.get());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findByName")
    public ResponseEntity<ProductResponseByName> getByName(@RequestBody @Valid ProductByName productByName) {
        if (Objects.isNull(productByName) || Objects.isNull(productByName.getName())) {
            return null;
        }
        Product product = productByNameMapper.mapToProduct(productByName);
        Optional<Product> byName = productManager.findByName(productByName.getName());
        if (byName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        ProductResponseByName productResponseByName = productByNameMapper.mapToProductResponseByName(byName.get());
        return ResponseEntity.ok().body(productResponseByName);
    }
}
