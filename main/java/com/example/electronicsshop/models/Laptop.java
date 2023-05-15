package com.example.electronicsshop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Laptop implements Parcelable {
    private int laptop_id;
    private String laptop_name;
    private String laptop_cpu;
    private String laptop_gpu;
    private String laptop_storage;
    private String laptop_ram;
    private String laptop_screen;
    private int laptop_photo;
    private int laptop_price;

    public Laptop(int laptop_id, String laptop_name, String laptop_cpu, String laptop_gpu, String laptop_storage, String laptop_ram, String laptop_screen, int laptop_photo, int laptop_price) {
        this.laptop_id = laptop_id;
        this.laptop_name = laptop_name;
        this.laptop_cpu = laptop_cpu;
        this.laptop_gpu = laptop_gpu;
        this.laptop_storage = laptop_storage;
        this.laptop_ram = laptop_ram;
        this.laptop_screen = laptop_screen;
        this.laptop_photo = laptop_photo;
        this.laptop_price = laptop_price;
    }

    public Laptop() {
        this.laptop_id = 0;
        this.laptop_name = null;
        this.laptop_cpu = null;
        this.laptop_gpu = null;
        this.laptop_storage = null;
        this.laptop_ram = null;
        this.laptop_screen = null;
        this.laptop_photo = 0;
        this.laptop_price = 0;
    }

    protected Laptop(Parcel in) {
        laptop_id = in.readInt();
        laptop_name = in.readString();
        laptop_cpu = in.readString();
        laptop_gpu = in.readString();
        laptop_storage = in.readString();
        laptop_ram = in.readString();
        laptop_screen = in.readString();
        laptop_photo = in.readInt();
        laptop_price = in.readInt();
    }

    public static final Creator<Laptop> CREATOR = new Creator<Laptop>() {
        @Override
        public Laptop createFromParcel(Parcel in) {
            return new Laptop(in);
        }

        @Override
        public Laptop[] newArray(int size) {
            return new Laptop[size];
        }
    };

    public int getLaptop_id() {
        return laptop_id;
    }

    public String getLaptop_name() {
        return laptop_name;
    }

    public String getLaptop_cpu() {
        return laptop_cpu;
    }

    public String getLaptop_gpu() {
        return laptop_gpu;
    }

    public String getLaptop_storage() {
        return laptop_storage;
    }

    public String getLaptop_ram() {
        return laptop_ram;
    }

    public String getLaptop_screen() {
        return laptop_screen;
    }

    public int getLaptop_photo() {
        return laptop_photo;
    }

    public int getLaptop_price() {
        return laptop_price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(laptop_id);
        dest.writeString(laptop_name);
        dest.writeString(laptop_cpu);
        dest.writeString(laptop_gpu);
        dest.writeString(laptop_storage);
        dest.writeString(laptop_ram);
        dest.writeString(laptop_screen);
        dest.writeInt(laptop_photo);
        dest.writeInt(laptop_price);
    }
}
