package com.example.newShop.controller;

import com.example.newShop.api.addProduct.request.AddProductRequest;
import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByNumber.response.ProductResponseByNumber;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.manager.ProductManager;
import com.example.newShop.mapper.ProductAddRequestMapper;
import com.example.newShop.mapper.ProductByNameMapper;
import com.example.newShop.mapper.ProductByNumberMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductManager productManager;
    private final ProductAddRequestMapper productAddRequestMapper;
    private final ProductByNumberMapper productByNumberMapper;
    private final ProductByNameMapper productByNameMapper;

    public ProductController(ProductManager productManager, ProductAddRequestMapper productAddRequestMapper, ProductByNumberMapper productByNumberMapper, ProductByNameMapper productByNameMapper) {
        this.productManager = productManager;
        this.productAddRequestMapper = productAddRequestMapper;
        this.productByNumberMapper = productByNumberMapper;
        this.productByNameMapper = productByNameMapper;
    }

    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody @Valid AddProductRequest request) {
//        if (Objects.isNull(request) || Objects.isNull(request.getGlobalCodeItemNumber())
//                || Objects.isNull(request.getName()) || Objects.isNull(request.getPrice())
//                || Objects.isNull(request.getType())) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
        Product product = productAddRequestMapper.mapToProduct(request);
        productManager.addProduct(product);
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
