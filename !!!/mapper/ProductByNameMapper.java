package com.example.newShop.mapper;

import com.example.newShop.api.findByName.request.ProductByName;
import com.example.newShop.api.findByName.response.ProductResponseByName;
import com.example.newShop.api.findByName.response.TypeResponseByName;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Type;
import org.springframework.stereotype.Component;

@Component
public class ProductByNameMapper {

    public Product mapToProduct(ProductByName source) {
        Product product = new Product();
        product.setName(source.getName());
        return product;
    }

    public ProductResponseByName mapToProductResponseByName(Product source) {
        ProductResponseByName productResponseByName = new ProductResponseByName();
        productResponseByName.setGlobalCodeItemNumber(source.getGlobalCodeItemNumber());
        productResponseByName.setName(source.getName());
        productResponseByName.setPrice(source.getPrice());
        productResponseByName.setType(mapType(source.getType()));
        return productResponseByName;
    }

    private TypeResponseByName mapType(Type source) {
        if (Type.FOOD.equals(source)) {
            return TypeResponseByName.FOOD;
        }
        return TypeResponseByName.INDUSTRIAL;
    }

}
