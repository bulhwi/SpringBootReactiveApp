package com.greglturnquist.hackingspringboot.reactive;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private @Id String id;
    private List<CartItem> cartItems;

    private Cart() {}

    public Cart(String id) {
        this(id, new ArrayList<>());
    }

    public Cart(String id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }

    public String getId() {
        return id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", cartItems=" + cartItems +
                '}';
    }
}
