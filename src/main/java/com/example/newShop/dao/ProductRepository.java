package com.example.newShop.dao;

import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByName(String name);

    Iterable<Product> findAllByName(String name);

    Optional<Product> findByType(Type type);

    Optional<Product> findByGlobalCodeItemNumber(String globalCodeItemNumber);

    @Transactional
    @Modifying
    @Query("update Product p set p.price = :price where p.name = :name")
    void updatePrice(String name,BigDecimal price);
}
