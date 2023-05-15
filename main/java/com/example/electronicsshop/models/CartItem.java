package com.example.electronicsshop.models;

public class CartItem {

    private int cartitem_id;
    private String cartitem_name;
    private int cartitem_price;
    private String user;

    public CartItem(int cartitem_id, String cartitem_name, int cartitem_price, String user) {
        this.cartitem_id = cartitem_id;
        this.cartitem_name = cartitem_name;
        this.cartitem_price = cartitem_price;
        this.user = user;
    }

    public int getCartitem_id() {
        return cartitem_id;
    }

    public String getCartitem_name() {
        return cartitem_name;
    }

    public int getCartitem_price() {
        return cartitem_price;
    }

    public String getUser() {
        return user;
    }
}
