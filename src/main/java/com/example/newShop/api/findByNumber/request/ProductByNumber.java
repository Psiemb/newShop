package com.example.newShop.api.findByNumber.request;

import javax.validation.constraints.NotBlank;

public class ProductByNumber {

    private Long id;
    @NotBlank
    private String globalCodeItemNumber;

    public Long getId() {
        return id;
    }

    public ProductByNumber setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGlobalCodeItemNumber() {
        return globalCodeItemNumber;
    }

    public ProductByNumber setGlobalCodeItemNumber(String globalCodeItemNumber) {
        this.globalCodeItemNumber = globalCodeItemNumber;
        return this;
    }
}
