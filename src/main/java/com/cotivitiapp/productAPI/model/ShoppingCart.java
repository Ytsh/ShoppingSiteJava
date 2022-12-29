package com.cotivitiapp.productAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Nullable
    private long id;
    private long quantity;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @JsonIgnoreProperties("shoppingCart")
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product productsCarts;

    @JsonIgnoreProperties("user")
    @ManyToOne()
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    private User user;

    public ShoppingCart() {
    }

    public ShoppingCart(long quantity, Product productsCarts, User user) {
        this.quantity = quantity;
        this.productsCarts = productsCarts;
        this.user = user;
    }
}
