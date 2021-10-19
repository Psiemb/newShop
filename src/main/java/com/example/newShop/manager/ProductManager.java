package com.example.newShop.manager;

import com.example.newShop.dao.ProductRepository;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductManager {

    private final ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void addProducts(List<Product> products) {
        products.forEach(productRepository::save);
    }

    public List<Product> addProducts2(List<Product> products) {
        return products.stream()
                .peek(productRepository::save)
                .collect(Collectors.toList());
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Iterable<Product> findAllByName(String name) {
        return productRepository.findAllByName(name);
    }

    public Optional<Product> findByGlobalCodeItemNumber(String globalCodeItemNumber) {
        return productRepository.findByGlobalCodeItemNumber(globalCodeItemNumber);
    }

    public Optional<Product> findByType(Type type) {
        return productRepository.findByType(type);
    }

    public void update(String name, BigDecimal price) {
        productRepository.updatePrice(name, price);
    }

}
