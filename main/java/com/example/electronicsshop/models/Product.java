package com.example.electronicsshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private int product_id;
    private String product_name;
    private String product_category;
    private int product_price;
    private int product_quantity;

    public Product(int id, String name, String category, int price, int quantity) {
        product_id = id;
        product_name = name;
        product_category = category;
        product_price = price;
        product_quantity = quantity;
    }

    public String getProductName() {
        return product_name;
    }

    public String getProductCategory() {
        return product_category;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public int getProductPrice() {
        return product_price;
    }

    protected Product(Parcel in) {
        product_id = in.readInt();
        product_name = in.readString();
        product_category = in.readString();
        product_price = in.readInt();
        product_quantity = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(product_id);
        dest.writeString(product_name);
        dest.writeString(product_category);
        dest.writeInt(product_price);
        dest.writeInt(product_quantity);
    }
}
