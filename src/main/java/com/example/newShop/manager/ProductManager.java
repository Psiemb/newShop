package com.example.newShop.manager;

import com.example.newShop.dao.ProductRepository;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductManager {

    private final ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findByNumber(Long index){
       return productRepository.findById(index);
    }
    public Optional<Product> findByName(String name){
        return productRepository.findByName(name);
    }

    public Optional<Product> findByGlobalCodeItemNumber(String globalCodeItemNumber){
        return productRepository.findByGlobalCodeItemNumber(globalCodeItemNumber);
    }

    public Optional<Product> findByType(Type type){
        return productRepository.findByType(type);
    }

}
