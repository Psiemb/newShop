package com.example.newShop.controller;

import com.example.newShop.api.addProduct.request.AddProductRequest;
import com.example.newShop.api.addProducts.request.AddProductsRequest;
import com.example.newShop.api.changePrice.request.ProductChangePrice;
import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.api.patchProduct.request.PatchPromotionRequest;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.manager.ProductManager;
import com.example.newShop.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductManager productManager;
    private final ProductAddRequestMapper productAddRequestMapper;
    private final ProductByNumberMapper productByNumberMapper;
    private final ProductByNameMapper productByNameMapper;
    private final ProductsAddRequestMapper productsAddRequestMapper;
    private final ProductPatchRequestMapper productPatchRequestMapper;

    public ProductController(ProductManager productManager, ProductAddRequestMapper productAddRequestMapper, ProductByNumberMapper productByNumberMapper, ProductByNameMapper productByNameMapper, ProductsAddRequestMapper productsAddRequestMapper, ProductPatchRequestMapper productPatchRequestMapper) {
        this.productManager = productManager;
        this.productAddRequestMapper = productAddRequestMapper;
        this.productByNumberMapper = productByNumberMapper;
        this.productByNameMapper = productByNameMapper;
        this.productsAddRequestMapper = productsAddRequestMapper;
        this.productPatchRequestMapper = productPatchRequestMapper;
    }

    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody @Valid AddProductRequest request) {
        Product product = productAddRequestMapper.mapToProduct(request);
        productManager.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/products/list")
    public ResponseEntity<Void> addProducts(@RequestBody @Valid AddProductsRequest request) {
        List<Product> products = productsAddRequestMapper.mapToProducts(request);
        productManager.addProducts(products);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/promotions/price")
    public ResponseEntity<Void> updateName(@RequestBody @Valid ProductChangePrice price) {
        Product product = productPatchRequestMapper.mapToProductPrice(price);
        productManager.update(product.getPrice(), product.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/promotions")
    public ResponseEntity<Void> patchProduct(@RequestBody PatchPromotionRequest request) {
        //TODO: dokonczyc update... kiedys tam
        Optional<Product> byName = productManager.findByName(request.getProductName());
        if (byName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Product product = productPatchRequestMapper.mapToProduct(request);
//        Product result = productPatchRequestMapper.mapToUpdatedProduct(byName.get(), product);
//        productManager.update(result);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<ProductResponseByName> getByName(@PathVariable(name = "productName") String name) {
        if (StringUtils.isBlank(name)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Optional<Product> byName = productManager.findByName(name);
        if (byName.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ProductResponseByName response = productByNameMapper.mapToProductResponseByName(byName.get());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/products/{productGCIN}")
    public ResponseEntity<ProductResponseByNumber> getByGlobalCodeItemNumber(@PathVariable(name = "productGCIN") String gcin) {
        if (StringUtils.isBlank(gcin)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Optional<Product> byGlobalCodeItemNumber = productManager.findByGlobalCodeItemNumber(gcin);
        if (byGlobalCodeItemNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ProductResponseByNumber response = productByNumberMapper.mapToProductResponseByNumber(byGlobalCodeItemNumber.get());
        return ResponseEntity.ok().body(response);
    }
}
