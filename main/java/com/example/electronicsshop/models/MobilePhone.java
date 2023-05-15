package com.example.electronicsshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MobilePhone implements Parcelable {

    private int phone_id;
    private String phone_name;
    private String phone_os;
    private String phone_screen;
    private String phone_cpu;
    private String phone_battery;
    private String phone_main_camera;
    private String phone_front_camera;
    private int phone_photo;
    private int phone_price;

    public MobilePhone(int phone_id, String phone_name, String phone_os, String phone_screen, String phone_cpu, String phone_battery, String phone_main_camera, String phone_front_camera, int phone_photo, int phone_price) {
        this.phone_id = phone_id;
        this.phone_name = phone_name;
        this.phone_os = phone_os;
        this.phone_screen = phone_screen;
        this.phone_cpu = phone_cpu;
        this.phone_battery = phone_battery;
        this.phone_main_camera = phone_main_camera;
        this.phone_front_camera = phone_front_camera;
        this.phone_photo = phone_photo;
        this.phone_price = phone_price;
    }

    public MobilePhone() {
        this.phone_id = 0;
        this.phone_name = null;
        this.phone_os = null;
        this.phone_screen = null;
        this.phone_cpu = null;
        this.phone_battery = null;
        this.phone_main_camera = null;
        this.phone_front_camera = null;
        this.phone_price = 0;
        this.phone_photo = 0;
    }

    protected MobilePhone(Parcel in) {
        phone_id = in.readInt();
        phone_name = in.readString();
        phone_os = in.readString();
        phone_screen = in.readString();
        phone_cpu = in.readString();
        phone_battery = in.readString();
        phone_main_camera = in.readString();
        phone_front_camera = in.readString();
        phone_price = in.readInt();
        phone_photo = in.readInt();
    }

    public static final Creator<MobilePhone> CREATOR = new Creator<MobilePhone>() {
        @Override
        public MobilePhone createFromParcel(Parcel in) {
            return new MobilePhone(in);
        }

        @Override
        public MobilePhone[] newArray(int size) {
            return new MobilePhone[size];
        }
    };

    public int getPhone_id() {
        return phone_id;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public String getPhone_os() {
        return phone_os;
    }

    public String getPhone_screen() {
        return phone_screen;
    }

    public String getPhone_cpu() {
        return phone_cpu;
    }

    public String getPhone_battery() {
        return phone_battery;
    }

    public String getPhone_main_camera() {
        return phone_main_camera;
    }

    public String getPhone_front_camera() {
        return phone_front_camera;
    }

    public int getPhone_price() {
        return phone_price;
    }

    public int getPhone_photo() {
        return phone_photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(phone_id);
        dest.writeString(phone_name);
        dest.writeString(phone_os);
        dest.writeString(phone_screen);
        dest.writeString(phone_cpu);
        dest.writeString(phone_battery);
        dest.writeString(phone_main_camera);
        dest.writeString(phone_front_camera);
        dest.writeInt(phone_price);
        dest.writeInt(phone_photo);
    }
}
