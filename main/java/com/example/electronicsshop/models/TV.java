package com.example.electronicsshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class TV implements Parcelable {

    private int tv_id;
    private String tv_name;
    private int tv_screen_size;
    private String tv_screen_type;
    private String tv_os;
    private String tv_speakers;
    private int tv_photo;
    private int tv_price;

    public TV(int tv_id, String tv_name, int tv_screen_size, String tv_screen_type, String tv_os, String tv_speakers, int tv_photo, int tv_price) {
        this.tv_id = tv_id;
        this.tv_name = tv_name;
        this.tv_screen_size = tv_screen_size;
        this.tv_screen_type = tv_screen_type;
        this.tv_os = tv_os;
        this.tv_speakers = tv_speakers;
        this.tv_photo = tv_photo;
        this.tv_price = tv_price;
    }

    public TV() {
        this.tv_id = 0;
        this.tv_name = null;
        this.tv_screen_size = 0;
        this.tv_screen_type = null;
        this.tv_os = null;
        this.tv_speakers = null;
        this.tv_photo = 0;
        this.tv_price = 0;
    }

    protected TV(Parcel in) {
        tv_id = in.readInt();
        tv_name = in.readString();
        tv_screen_size = in.readInt();
        tv_screen_type = in.readString();
        tv_os = in.readString();
        tv_speakers = in.readString();
        tv_photo = in.readInt();
        tv_price = in.readInt();
    }

    public static final Creator<TV> CREATOR = new Creator<TV>() {
        @Override
        public TV createFromParcel(Parcel in) {
            return new TV(in);
        }

        @Override
        public TV[] newArray(int size) {
            return new TV[size];
        }
    };

    public int getTv_id() {
        return tv_id;
    }

    public String getTv_name() {
        return tv_name;
    }

    public int getTv_screen_size() {
        return tv_screen_size;
    }

    public String getTv_screen_type() {
        return tv_screen_type;
    }

    public String getTv_os() {
        return tv_os;
    }

    public String getTv_speakers() {
        return tv_speakers;
    }

    public int getTv_photo() {
        return tv_photo;
    }

    public int getTv_price() {
        return tv_price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tv_id);
        dest.writeString(tv_name);
        dest.writeInt(tv_screen_size);
        dest.writeString(tv_screen_type);
        dest.writeString(tv_os);
        dest.writeString(tv_speakers);
        dest.writeInt(tv_photo);
        dest.writeInt(tv_price);
    }
}
