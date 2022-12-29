package com.cotivitiapp.productAPI.repository;

import com.cotivitiapp.productAPI.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findShoppingCartByUserId(Long user_id);
//    ShoppingCart findShoppingCartByProductsCartsId(Long product_id);
}
