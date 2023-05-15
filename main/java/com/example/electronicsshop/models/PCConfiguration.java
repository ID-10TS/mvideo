package com.example.electronicsshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class PCConfiguration implements Parcelable {
    private int configuration_id;
    private String configuration_name;
    private String configuration_cpu;
    private String configuration_gpu;
    private String configuration_ram;
    private String configuration_motherboard;
    private String configuration_storage;
    private String configuration_psu;
    private String configuration_case;
    private int configuration_photo;
    private int configuration_price;

    public PCConfiguration(int configuration_id, String configuration_name, String configuration_cpu, String configuration_gpu, String configuration_ram, String configuration_motherboard, String configuration_storage, String configuration_psu, String configuration_case, int configuration_photo, int configuration_price) {
        this.configuration_id = configuration_id;
        this.configuration_name = configuration_name;
        this.configuration_cpu = configuration_cpu;
        this.configuration_gpu = configuration_gpu;
        this.configuration_ram = configuration_ram;
        this.configuration_motherboard = configuration_motherboard;
        this.configuration_storage = configuration_storage;
        this.configuration_psu = configuration_psu;
        this.configuration_case = configuration_case;
        this.configuration_photo = configuration_photo;
        this.configuration_price = configuration_price;
    }

    public PCConfiguration() {
        this.configuration_id = 0;
        this.configuration_name = null;
        this.configuration_cpu = null;
        this.configuration_gpu = null;
        this.configuration_ram = null;
        this.configuration_motherboard = null;
        this.configuration_storage = null;
        this.configuration_psu = null;
        this.configuration_case = null;
        this.configuration_photo = 0;
        this.configuration_price = 0;
    }

    protected PCConfiguration(Parcel in) {
        configuration_id = in.readInt();
        configuration_name = in.readString();
        configuration_cpu = in.readString();
        configuration_gpu = in.readString();
        configuration_ram = in.readString();
        configuration_motherboard = in.readString();
        configuration_storage = in.readString();
        configuration_psu = in.readString();
        configuration_case = in.readString();
        configuration_photo = in.readInt();
        configuration_price = in.readInt();
    }

    public static final Creator<PCConfiguration> CREATOR = new Creator<PCConfiguration>() {
        @Override
        public PCConfiguration createFromParcel(Parcel in) {
            return new PCConfiguration(in);
        }

        @Override
        public PCConfiguration[] newArray(int size) {
            return new PCConfiguration[size];
        }
    };

    public int getConfiguration_id() {
        return configuration_id;
    }

    public String getConfiguration_name() {
        return configuration_name;
    }

    public String getConfiguration_cpu() {
        return configuration_cpu;
    }

    public String getConfiguration_gpu() {
        return configuration_gpu;
    }

    public String getConfiguration_ram() {
        return configuration_ram;
    }

    public String getConfiguration_motherboard() {
        return configuration_motherboard;
    }

    public String getConfiguration_storage() {
        return configuration_storage;
    }

    public String getConfiguration_psu() {
        return configuration_psu;
    }

    public String getConfiguration_case() {
        return configuration_case;
    }

    public int getConfiguration_photo() {
        return configuration_photo;
    }

    public int getConfiguration_price() {
        return configuration_price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(configuration_id);
        dest.writeString(configuration_name);
        dest.writeString(configuration_cpu);
        dest.writeString(configuration_gpu);
        dest.writeString(configuration_ram);
        dest.writeString(configuration_motherboard);
        dest.writeString(configuration_storage);
        dest.writeString(configuration_psu);
        dest.writeString(configuration_case);
        dest.writeInt(configuration_photo);
        dest.writeInt(configuration_price);
    }
}
