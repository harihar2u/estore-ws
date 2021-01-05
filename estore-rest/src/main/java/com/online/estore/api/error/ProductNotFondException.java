package com.online.estore.acs.api.error;

public class ProductNotFondException extends RuntimeException {

    public ProductNotFondException(Long id) {
        super(String.format("Product not found %s", id));
    }
}
