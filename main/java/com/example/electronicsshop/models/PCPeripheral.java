package com.example.electronicsshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PCPeripheral implements Parcelable {
    private int peripheral_id;
    private String peripheral_name;
    private String peripheral_type;
    private String peripheral_info;
    private int peripheral_photo;
    private int peripheral_price;

    public PCPeripheral(int peripheral_id, String peripheral_name, String peripheral_type, String peripheral_info, int peripheral_photo, int peripheral_price) {
        this.peripheral_id = peripheral_id;
        this.peripheral_name = peripheral_name;
        this.peripheral_type = peripheral_type;
        this.peripheral_info = peripheral_info;
        this.peripheral_photo = peripheral_photo;
        this.peripheral_price = peripheral_price;
    }

    public PCPeripheral() {
        this.peripheral_id = 0;
        this.peripheral_name = null;
        this.peripheral_type = null;
        this.peripheral_info = null;
        this.peripheral_photo = 0;
        this.peripheral_price = 0;
    }

    protected PCPeripheral(Parcel in) {
        peripheral_id = in.readInt();
        peripheral_name = in.readString();
        peripheral_type = in.readString();
        peripheral_info = in.readString();
        peripheral_photo = in.readInt();
        peripheral_price = in.readInt();
    }

    public static final Creator<PCPeripheral> CREATOR = new Creator<PCPeripheral>() {
        @Override
        public PCPeripheral createFromParcel(Parcel in) {
            return new PCPeripheral(in);
        }

        @Override
        public PCPeripheral[] newArray(int size) {
            return new PCPeripheral[size];
        }
    };

    public int getPeripheral_id() {
        return peripheral_id;
    }

    public String getPeripheral_name() {
        return peripheral_name;
    }

    public String getPeripheral_type() {
        return peripheral_type;
    }

    public String getPeripheral_info() {
        return peripheral_info;
    }

    public int getPeripheral_photo() {
        return peripheral_photo;
    }

    public int getPeripheral_price() {
        return peripheral_price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(peripheral_id);
        dest.writeString(peripheral_name);
        dest.writeString(peripheral_type);
        dest.writeString(peripheral_info);
        dest.writeInt(peripheral_photo);
        dest.writeInt(peripheral_price);
    }
}
