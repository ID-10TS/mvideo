package com.example.electronicsshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PCComponent implements Parcelable {
    private int component_id;
    private String component_name;
    private String component_type;
    private String component_info;
    private int component_photo;
    private int component_price;

    public PCComponent(int component_id, String component_name, String component_type, String component_info, int component_photo, int component_price) {
        this.component_id = component_id;
        this.component_name = component_name;
        this.component_type = component_type;
        this.component_info = component_info;
        this.component_photo = component_photo;
        this.component_price = component_price;
    }

    public PCComponent() {
        this.component_id = 0;
        this.component_name = null;
        this.component_type = null;
        this.component_info = null;
        this.component_photo = 0;
        this.component_price = 0;
    }

    protected PCComponent(Parcel in) {
        component_id = in.readInt();
        component_name = in.readString();
        component_type = in.readString();
        component_info = in.readString();
        component_photo = in.readInt();
        component_price = in.readInt();
    }

    public static final Creator<PCComponent> CREATOR = new Creator<PCComponent>() {
        @Override
        public PCComponent createFromParcel(Parcel in) {
            return new PCComponent(in);
        }

        @Override
        public PCComponent[] newArray(int size) {
            return new PCComponent[size];
        }
    };

    public int getComponent_id() {
        return component_id;
    }

    public String getComponent_name() {
        return component_name;
    }

    public String getComponent_type() {
        return component_type;
    }

    public String getComponent_info() {
        return component_info;
    }

    public int getComponent_photo() {
        return component_photo;
    }

    public int getComponent_price() {
        return component_price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(component_id);
        dest.writeString(component_name);
        dest.writeString(component_type);
        dest.writeString(component_info);
        dest.writeInt(component_photo);
        dest.writeInt(component_price);
    }
}
