package com.example.newShop.api.addProducts.request;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AddProductsRequest {

    @NotNull
    private List<ProductRequest> requests;

    public List<ProductRequest> getRequests() {
        return requests;
    }

    public AddProductsRequest setRequests(List<ProductRequest> requests) {
        this.requests = requests;
        return this;
    }
}
