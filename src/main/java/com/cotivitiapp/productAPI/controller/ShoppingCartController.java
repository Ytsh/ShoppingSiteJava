package com.cotivitiapp.productAPI.controller;


import com.cotivitiapp.productAPI.DTO.cartDTO;
import com.cotivitiapp.productAPI.model.ShoppingCart;
import com.cotivitiapp.productAPI.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;
    @GetMapping("/shoppingCart/{userId}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable long userId)
    {
//        this.shoppingCartService.getShoppingCartByUserId(userId);
        return ResponseEntity.ok().body(shoppingCartService.getShoppingCartByUserId(userId));
    }
    @PostMapping("/shoppingCart")
    public ResponseEntity<cartDTO> createCart(@RequestBody cartDTO shoppingCart)
    {
        return ResponseEntity.ok().body(shoppingCartService.createShoppingCart(shoppingCart));
    }
    @PutMapping("/shoppingCart")
    public ResponseEntity<ShoppingCart> updateCart(@RequestBody ShoppingCart shoppingCart)
    {
        return ResponseEntity.ok().body(shoppingCartService.updateShoppingCart(shoppingCart));
    }
    @DeleteMapping("/shoppingCart/{id}")
    public HttpStatus deleteCart(@RequestBody long id)
    {
        this.shoppingCartService.deleteShoppingCart(id);
        return HttpStatus.OK;
    }
}
