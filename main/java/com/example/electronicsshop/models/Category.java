package com.example.electronicsshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
    private String category_name;

    private int category_image;

    public Category(String name, int category_image) {
        this.category_image = category_image;
        category_name = name;
    }

    public String getName() {
        return category_name;
    }

    public int getImage() {
        return category_image;
    }


    protected Category(Parcel in) {
        category_name = in.readString();
        category_image = in.readInt();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(category_name);
    }
}
