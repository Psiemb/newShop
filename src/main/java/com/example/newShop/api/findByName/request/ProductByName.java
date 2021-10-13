package com.example.newShop.api.findByName.request;

import javax.validation.constraints.NotBlank;

public class ProductByName {

    private Long idRequest;
    @NotBlank
    private String name;

    public Long getIdRequest() {
        return idRequest;
    }

    public ProductByName setIdRequest(Long idRequest) {
        this.idRequest = idRequest;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductByName setName(String name) {
        this.name = name;
        return this;
    }
}
