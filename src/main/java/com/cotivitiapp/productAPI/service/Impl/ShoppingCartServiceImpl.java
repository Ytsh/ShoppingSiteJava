package com.cotivitiapp.productAPI.service.Impl;

import com.cotivitiapp.productAPI.DTO.cartDTO;
import com.cotivitiapp.productAPI.exception.ResourceNotFoundException;
import com.cotivitiapp.productAPI.model.ShoppingCart;
import com.cotivitiapp.productAPI.model.User;
import com.cotivitiapp.productAPI.repository.ShoppingCartRepository;
import com.cotivitiapp.productAPI.repository.UserRepository;
import com.cotivitiapp.productAPI.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public cartDTO createShoppingCart(cartDTO cartdto) {
         ShoppingCart sc = new ShoppingCart();
        List<ShoppingCart> carts = (List<ShoppingCart>) shoppingCartRepository.findShoppingCartByUserId(cartdto.getUserId());
        boolean isProductExists = false;

        for(ShoppingCart cartItem: carts)
        {
            if(cartItem.getProductsCarts().getId() == cartdto.getProductsCarts().getId())
            {
                isProductExists = true;
                Long newQuantity = cartItem.getQuantity() + cartdto.getQuantity();
                cartItem.setQuantity(newQuantity);
                sc = this.shoppingCartRepository.save(cartItem);
                break;
            }
        }
        if(!isProductExists){
            User user = this.userRepository.findById(cartdto.getUserId()).orElse(null);
            ShoppingCart shoppingCart = new ShoppingCart(cartdto.getQuantity(),cartdto.getProductsCarts(),user);
            sc = this.shoppingCartRepository.save(shoppingCart);
        }
        cartdto.setId(sc.getId());
        cartdto.setQuantity(sc.getQuantity());
        cartdto.setProductsCarts(sc.getProductsCarts());
        cartdto.setUserId(sc.getUser().getId());

        return cartdto;
    }


    @Override
    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
        ShoppingCart s = this.shoppingCartRepository.findById(shoppingCart.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Shopping cart not found"));
//
        s.setProductsCarts(shoppingCart.getProductsCarts());
        s.setQuantity(shoppingCart.getQuantity());
//        s.setUser(shoppingCart.getUser());
        this.shoppingCartRepository.save(s);
        return s;
    }

    @Override
    public ShoppingCart getShoppingCartByUserId(Long userId) {
        ShoppingCart sc = this.shoppingCartRepository.findShoppingCartByUserId(userId);
        return sc;
//        return null;
    }

    @Override
    public void deleteShoppingCart(Long shoppingCartId) {
        ShoppingCart sc = this.shoppingCartRepository.findById(shoppingCartId).orElseThrow(() ->
                new ResourceNotFoundException("Shopping cart not found"));
        this.shoppingCartRepository.delete(sc);
    }


}
