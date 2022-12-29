package com.cotivitiapp.productAPI.service;

import com.cotivitiapp.productAPI.DTO.cartDTO;
import com.cotivitiapp.productAPI.model.ShoppingCart;

public interface ShoppingCartService {
    cartDTO createShoppingCart(cartDTO ShoppingCart);
    ShoppingCart updateShoppingCart(ShoppingCart ShoppingCart);
//    List<ShoppingCart> getAllShoppingCart();
    ShoppingCart getShoppingCartByUserId(Long userId);
    void deleteShoppingCart(Long ShoppingCartId);






}
