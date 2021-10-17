package com.example.newShop.api.addProducts.request;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class AddProductsRequest {

    @NotEmpty
    private List<ProductRequest> products;

    public List<ProductRequest> getProducts() {
        return products;
    }

    public AddProductsRequest setProducts(List<ProductRequest> products) {
        this.products = products;
        return this;
    }
}
