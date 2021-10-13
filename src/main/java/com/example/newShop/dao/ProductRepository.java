package com.example.newShop.dao;

import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByName(String name);
    Optional<Product> findByType(Type type);
    Optional<Product> findByGlobalCodeItemNumber(String globalCodeItemNumber);
}
