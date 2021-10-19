package com.example.newShop.api.findByName.response;

import java.util.List;

public class ProductsResponseByName {

    private List<ProductResponseByName> byName;

    public List<ProductResponseByName> getByName() {
        return byName;
    }

    public ProductsResponseByName setByName(List<ProductResponseByName> byName) {
        this.byName = byName;
        return this;
    }
}
