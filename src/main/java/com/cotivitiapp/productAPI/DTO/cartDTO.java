package com.cotivitiapp.productAPI.DTO;

import com.cotivitiapp.productAPI.model.Product;

public class cartDTO {
    private long id;
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Product getProductsCarts() {
        return productsCarts;
    }

    public void setProductsCarts(Product productsCarts) {
        this.productsCarts = productsCarts;
    }

    private long quantity;

    public cartDTO() {
    }

    private Product productsCarts;
}
