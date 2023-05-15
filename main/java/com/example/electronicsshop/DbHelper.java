package com.example.electronicsshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.core.view.KeyEventDispatcher;

import com.example.electronicsshop.models.CartItem;
import com.example.electronicsshop.models.Category;
import com.example.electronicsshop.models.Laptop;
import com.example.electronicsshop.models.MobilePhone;
import com.example.electronicsshop.models.PCComponent;
import com.example.electronicsshop.models.PCConfiguration;
import com.example.electronicsshop.models.PCPeripheral;
import com.example.electronicsshop.models.Product;
import com.example.electronicsshop.models.TV;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Database20.db";

    public DbHelper(Context context) {
        super(context, "Database20.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT primary key, password TEXT, email TEXT)");
        db.execSQL("create Table categories(category TEXT primary key, category_photo INTEGER)");
        db.execSQL("create Table products(product_id INTEGER primary key, product_name TEXT, product_category TEXT, product_price INTEGER, product_quantity INTEGER)");
        db.execSQL("create Table phones(phone_id INTEGER primary key, phone_name TEXT, phone_os TEXT, phone_screen TEXT, phone_cpu TEXT, phone_battery TEXT, phone_main_camera TEXT, phone_front_camera TEXT, phone_photo INTEGER, phone_price INTEGER)");
        db.execSQL("create Table ТВ(tv_id INTEGER primary key, tv_name TEXT, tv_screen_size INTEGER, tv_screen_type TEXT, tv_os TEXT, tv_speakers TEXT, tv_photo INTEGER, tv_price INTEGER)");
        db.execSQL("create Table configurations(configuration_id INTEGER primary key, configuration_name TEXT, configuration_cpu TEXT, configuration_gpu TEXT, configuration_ram TEXT, configuration_motherboard TEXT, configuration_storage TEXT, configuration_psu TEXT, configuration_case TEXT, configuration_photo INTEGER, configuration_price INTEGER)");
        db.execSQL("create Table components(component_id INTEGER primary key, component_name TEXT, component_type TEXT, component_info TEXT, component_photo INTEGER, component_price INTEGER)");
        db.execSQL("create Table peripherals(peripheral_id INTEGER primary key, peripheral_name TEXT, peripheral_type TEXT, peripheral_info TEXT, peripheral_photo INTEGER, peripheral_price INTEGER)");
        db.execSQL("create Table laptops(laptop_id INTEGER primary key, laptop_name TEXT, laptop_cpu TEXT, laptop_gpu TEXT, laptop_storage TEXT, laptop_ram TEXT, laptop_screen TEXT, laptop_photo INTEGER, laptop_price INTEGER)");
        db.execSQL("create Table cartitems(cartitem_id INTEGER primary key autoincrement, item_name TEXT, item_price INTEGER, user TEXT)");

        db.execSQL("INSERT INTO categories VALUES ('Мобильные телефоны', '2131165397');");
        db.execSQL("INSERT INTO categories VALUES ('ТВ', '2131165398');");
        db.execSQL("INSERT INTO categories VALUES ('Конфигурации ПК', '2131165399');");
        db.execSQL("INSERT INTO categories VALUES ('Компоненты ПК', '2131165400');");
        db.execSQL("INSERT INTO categories VALUES ('Переферия', '2131165401');");
        db.execSQL("INSERT INTO categories VALUES ('Ноутбуки', '2131165402');");

        db.execSQL("INSERT INTO products VALUES (1, 'iPhone 12 Pro Max', 'Мобильные телефоны', 1099, 10);");
        db.execSQL("INSERT INTO products VALUES (2, 'iPhone 12 Pro', 'Мобильные телефоны', 999, 10);");
        db.execSQL("INSERT INTO products VALUES (3, 'iPhone 12', 'Мобильные телефоны', 799, 20);");
        db.execSQL("INSERT INTO products VALUES (4, 'iPhone 12 mini', 'Мобильные телефоны', 699, 15);");
        db.execSQL("INSERT INTO products VALUES (5, 'iPhone SE (2020)', 'Мобильные телефоны', 399, 20);");
        db.execSQL("INSERT INTO products VALUES (6, 'Samsung Galaxy S21', 'Мобильные телефоны', 799, 30);");
        db.execSQL("INSERT INTO products VALUES (7, 'Samsung Galaxy S21 Plus', 'Мобильные телефоны', 999, 30);");
        db.execSQL("INSERT INTO products VALUES (8, 'Samsung Galaxy S21 Ultra', 'Мобильные телефоны', 1199, 20);");
        db.execSQL("INSERT INTO products VALUES (9, 'Xiaomi Mi 11', 'Мобильные телефоны', 399, 5);");
        db.execSQL("INSERT INTO products VALUES (10, 'LG 32LN575S', 'ТВ', 399, 0);");
        db.execSQL("INSERT INTO products VALUES (11, 'Toshiba 49UA2063DG', 'ТВ', 399, 5);");
        db.execSQL("INSERT INTO products VALUES (12, 'Samsung 43NU7022', 'ТВ', 349, 10);");
        db.execSQL("INSERT INTO products VALUES (13, 'Samsung 65 Q70T', 'ТВ', 1099, 2);");
        db.execSQL("INSERT INTO products VALUES (14, 'Basic', 'Конфигурации ПК', 399, 5);");
        db.execSQL("INSERT INTO products VALUES (15, 'Gamer', 'Конфигурации ПК', 699, 5);");
        db.execSQL("INSERT INTO products VALUES (16, 'Gamer Pro', 'Конфигурации ПК', 999, 3);");
        db.execSQL("INSERT INTO products VALUES (17, 'Gamer Elite', 'Конфигурации ПК', 1299, 2);");
        db.execSQL("INSERT INTO products VALUES (18, 'AMD Ryzen 5 5600X', 'Компоненты ПК', 299, 0);");
        db.execSQL("INSERT INTO products VALUES (19, 'AMD Ryzen 5 3600', 'Компоненты ПК', 199, 15);");
        db.execSQL("INSERT INTO products VALUES (20, 'AMD Ryzen 7 5800X', 'Компоненты ПК', 399, 2);");
        db.execSQL("INSERT INTO products VALUES (21, 'Intel i5 10600K', 'Компоненты ПК', 249, 5);");
        db.execSQL("INSERT INTO products VALUES (22, 'Asus Rog Strix B550 F-Gaming', 'Компоненты ПК', 149, 7);");
        db.execSQL("INSERT INTO products VALUES (23, 'HyperX Predator RGB', 'Компоненты ПК', 49, 30);");
        db.execSQL("INSERT INTO products VALUES (24, 'G.Skill TridenZ Neo RGB', 'Компоненты ПК', 59, 25);");
        db.execSQL("INSERT INTO products VALUES (25, 'BeQuiet Dark Power Pro 11 650W', 'Компоненты ПК', 99, 10);");
        db.execSQL("INSERT INTO products VALUES (26, 'NZXT H510', 'Компоненты ПК', 69, 10);");
        db.execSQL("INSERT INTO products VALUES (27, 'NZXT H510 Elite', 'Компоненты ПК', 149, 5);");
        db.execSQL("INSERT INTO products VALUES (28, 'Samsung 860 Evo 250GB', 'Компоненты ПК', 29, 50);");
        db.execSQL("INSERT INTO products VALUES (29, 'Samsung 860 Evo 500GB', 'Компоненты ПК', 39, 55);");
        db.execSQL("INSERT INTO products VALUES (30, 'Kingston A400 480GB', 'Компоненты ПК', 29, 40);");
        db.execSQL("INSERT INTO products VALUES (31, 'AMD Radeon RX 5500 XT 8GB', 'Компоненты ПК', 129, 20);");
        db.execSQL("INSERT INTO products VALUES (32, 'Nvidia RTX3060Ti', 'Компоненты ПК', 399, 5);");
        db.execSQL("INSERT INTO products VALUES (33, 'Nvidia RTX3060', 'Компоненты ПК', 499, 1);");
        db.execSQL("INSERT INTO products VALUES (35, 'Glorious Model O', 'Переферия', 49, 15);");
        db.execSQL("INSERT INTO products VALUES (36, 'Glorious Model D', 'Переферия', 49, 15);");
        db.execSQL("INSERT INTO products VALUES (37, 'Glorious Model O-', 'Переферия', 49, 10);");
        db.execSQL("INSERT INTO products VALUES (38, 'Glorious Model D-', 'Переферия', 49, 10);");
        db.execSQL("INSERT INTO products VALUES (39, 'Glorious Model O Wireless', 'Переферия', 79, 5);");
        db.execSQL("INSERT INTO products VALUES (40, 'HyperX Pulsefire Haste', 'Переферия', 49, 10);");
        db.execSQL("INSERT INTO products VALUES (41, 'HyperX Origins Core', 'Переферия', 89, 15);");
        db.execSQL("INSERT INTO products VALUES (42, 'HyperX Cloud II', 'Переферия', 99, 20);");
        db.execSQL("INSERT INTO products VALUES (43, 'SteelSeries Apex 7', 'Переферия', 189, 5);");
        db.execSQL("INSERT INTO products VALUES (44, 'Logitech G Pro X Superlight', 'Переферия', 199, 5);");
        db.execSQL("INSERT INTO products VALUES (45, 'LG 27GN950-B', 'Переферия', 1199, 2);");
        db.execSQL("INSERT INTO products VALUES (46, 'Gigabyte G27Q', 'Переферия', 699, 3);");
        db.execSQL("INSERT INTO products VALUES (47, 'Aoc 24V2Q', 'Переферия', 119, 10);");
        db.execSQL("INSERT INTO products VALUES (48, 'Apple Macbook Air', 'Ноутбуки', 999, 10);");
        db.execSQL("INSERT INTO products VALUES (49, 'HP Envy X360', 'Ноутбуки', 749, 10);");
        db.execSQL("INSERT INTO products VALUES (50, 'Apple Macbook Pro 13', 'Ноутбуки', 1299, 5);");
        db.execSQL("INSERT INTO products VALUES (51, 'Dell XPS 13', 'Ноутбуки', 1099, 10);");
        db.execSQL("INSERT INTO products VALUES (52, 'Asus Rog Zephyrus G14', 'Ноутбуки', 1449, 5);");

        db.execSQL("INSERT INTO phones VALUES (1, 'iPhone 12', 'iOS 14', '6.1 Inch', 'Apple A14 Bionic', '2815 mAh', '12MP Wide / 12MP Ultrawide', '12MP Wide', 2131165329, 799);");
        db.execSQL("INSERT INTO phones VALUES (2, 'iPhone 12 Pro Max', 'iOS 14', '6.7 Inch', 'Apple A14 Bionic', '3687 mAh', '12MP Wide / 12MP Ultrawide / 12MP Telephoto', '12MP Wide', 2131165325, 1099);");
        db.execSQL("INSERT INTO phones VALUES (3, 'iPhone 12 Pro', 'iOS 14', '6.1 Inch', 'Apple A14 Bionic', '2815 mAh', '12MP Wide / 12MP Ultrawide / 12MP Telephoto', '12MP Wide', 2131165324, 999);");
        db.execSQL("INSERT INTO phones VALUES (4, 'iPhone 12 mini', 'iOS 14', '5.4 Inch', 'Apple A14 Bionic', '2227 mAh', '12MP Wide / 12MP Ultrawide', '12MP Wide', 2131165323, 699);");
        db.execSQL("INSERT INTO phones VALUES (5, 'iPhone SE (2020)', 'iOS 14', '4.7 Inch', 'Apple A13 Bionic', '1821 mAh', '12MP Wide', '7MP Wide', 2131165326, 399);");
        db.execSQL("INSERT INTO phones VALUES (6, 'Samsung Galaxy S21', 'Android 11 - One UI 3', '6.2 Inch', 'Exynos 2100', '400 mAh', '12MP Wide / 12MP Ultrawide / 64MP Telephoto', '10MP Wide', 2131165377, 799);");
        db.execSQL("INSERT INTO phones VALUES (7, 'Samsung Galaxy S21 Plus', 'Android 11 - One UI 3', '6.7 Inch', 'Exynos 2100', '4800 mAh', '12MP Wide / 12MP Ultrawide / 64MP Telephoto', '10MP Wide', 2131165378, 999);");
        db.execSQL("INSERT INTO phones VALUES (8, 'Samsung Galaxy S21 Ultra', 'Android 11 - One UI 3', '6.8 Inch', 'Exynos 2100', '5000 mAh', '108MP Wide / 12MP Ultrawide / 10MP Telephoto / 10MP Periscope Telephoto', '40MP Wide', 2131165379, 1199);");
        db.execSQL("INSERT INTO phones VALUES (9, 'Xiaomi Mi 11', 'Android 11 - MIUI 12.5', '6.81 Inch', 'Snapdragon 888', '4600 mAh', '108MP Wide / 13MP Ultrawide / 5MP Macro', '20MP Wide', 2131165339, 769);");

        db.execSQL("INSERT INTO ТВ VALUES (1, 'LG 32LN575S', '32 Inch', 'IPS ', 'Web OS', '2 x 5W', 2131165328, 399);");
        db.execSQL("INSERT INTO ТВ VALUES (2, 'Toshiba 49UA2063DG', '49 Inch', 'IPS ', 'Android TV', '2 x 10W', 2131165386, 399);");
        db.execSQL("INSERT INTO ТВ VALUES (3, 'Samsung 43NU7022', '43 Inch', 'IPS ', 'Tyzen OS', '2 x 5W', 2131165380, 349);");
        db.execSQL("INSERT INTO ТВ VALUES (4, 'Samsung 65 Q70T', '65 Inch', 'QLED ', 'Tyzen OS', '2 x 15W', 2131165381, 1099);");

        db.execSQL("INSERT INTO configurations VALUES (1, 'Basic', 'Intel i3 10100F', 'Nvidia GTX 1660 Super', '2 x 8GB DDR4 2666MHz', 'H410', 'Western Digital 1TB HDD 7200rpm', 'CM 500W MWE Bronze 80', 'DeepCool Matrexx 55', 2131165368, 399);");
        db.execSQL("INSERT INTO configurations VALUES (2, 'Gamer', 'Intel i5 10500F', 'Nvidia RTX 2060', '2 x 8GB DDR4 3200MHz', 'Z490', 'Western Digital 1TB HDD 7200rpm / 250GB NVMe SSD', 'CM 650W MWE Bronze 80', 'DeepCool Matrexx 75', 2131165369, 699);");
        db.execSQL("INSERT INTO configurations VALUES (3, 'Gamer Pro', 'AMD Ryzen 5 5600X', 'AMD Radeon RX 5700 XT', '2 x 8GB DDR4 3600MHz', 'B550', 'Western Digital 2TB HDD 7200rpm / 500GB m.2 NVMe SSD', 'NZXT C650', 'NZXT H510', 2131165302, 999);");
        db.execSQL("INSERT INTO configurations VALUES (4, 'Gamer Elite', 'AMD Ryzen 7 5800X', 'AMD Radeon Rx 6800 XT', '4 x 16GB DDR4 3600MHz', 'X570', 'Western Digital 4TB HDD 7200rpm / 1TB m.2 NVMe PCIe4 SSD', 'NZXT C850', 'NZXT H510 Elite', 2131165301, 1499);");

        db.execSQL("INSERT INTO components VALUES (1, 'AMD Ryzen 5 5600X', 'CPU', '6 Core, 12 Threads / 3.7GHz Base, 4.6GHZ Boost', 2131165375, 299);");
        db.execSQL("INSERT INTO components VALUES (2, 'AMD Ryzen 5 3600', 'CPU', '6 Core, 12 Threads / 3.6GHz Base, 4.2GHZ Boost', 2131165374, 199);");
        db.execSQL("INSERT INTO components VALUES (3, 'AMD Ryzen 7 5800X', 'CPU', '8 Core, 16 Threads / 3.8GHz Base, 4.7GHZ Boost', 2131165376, 399);");
        db.execSQL("INSERT INTO components VALUES (4, 'Intel i5 10600K', 'CPU', '6 Core, 12 Threads / 4.1GHz Base, 4.8GHZ Boost', 2131165321, 249);");
        db.execSQL("INSERT INTO components VALUES (5, 'Asus Rog Strix B550 F-Gaming', 'Motherboard', 'AM4 Socket / PCIe 4.0 / RGB', 2131165281, 149);");
        db.execSQL("INSERT INTO components VALUES (6, 'HyperX Predator RGB', 'RAM', 'DDR4 / 3200MHz / Infrared Sync / Samsung B-die / RGB', 2131165370, 49);");
        db.execSQL("INSERT INTO components VALUES (7, 'G.Skill TridenZ Neo RGB', 'RAM', 'DDR4 / 3600MHz / Samsung B-die / RGB', 2131165387, 59);");
        db.execSQL("INSERT INTO components VALUES (8, 'BeQuiet Dark Power Pro 11 650W', 'PSU', '80 Gold Plus / Semi Modular', 2131165283, 99);");
        db.execSQL("INSERT INTO components VALUES (9, 'NZXT H510', 'Case', 'Minimalistic Design / Tempered Glass / 2 x 120mm Fans', 2131165305, 69);");
        db.execSQL("INSERT INTO components VALUES (10, 'NZXT H510 Elite', 'Case', 'Minimalistic Design / 2 x Tempered Glass / 2 x 120mm Fans / 2 x 140mm RGB Fans', 2131165306, 149);");
        db.execSQL("INSERT INTO components VALUES (11, 'Samsung 860 Evo 250GB', 'SSD', 'Fast SATA SSD', 2131165382, 29);");
        db.execSQL("INSERT INTO components VALUES (12, 'Samsung 860 Evo 500GB', 'SSD', 'Fast SATA SSD', 2131165382, 39);");
        db.execSQL("INSERT INTO components VALUES (13, 'Kingston A400 480GB', 'SSD', 'Fast SATA SSD', 2131165327, 29);");
        db.execSQL("INSERT INTO components VALUES (14, 'AMD Radeon RX 5500 XT 8GB', 'GPU', '8GB GDDR6 / 1865 MHz / 128bit', 2131165373, 129);");
        db.execSQL("INSERT INTO components VALUES (15, 'Nvidia RTX3060Ti', 'GPU', '8GB GDDR6 / 1680MHz / 256bit', 2131165372, 399);");
        db.execSQL("INSERT INTO components VALUES (16, 'Nvidia RTX3060', 'CPU', '12GB GDDR6 / 1780MHz / 192bit', 2131165371, 399);");

        db.execSQL("INSERT INTO peripherals VALUES (1, 'Glorious Model O', 'Gaming Mouse', 'PMW 3360 Optical Sensor / 67grams', 2131165342, 49);");
        db.execSQL("INSERT INTO peripherals VALUES (2, 'Glorious Model D', 'Gaming Mouse', 'PMW 3360 Optical Sensor / 69grams', 2131165340, 49);");
        db.execSQL("INSERT INTO peripherals VALUES (3, 'Glorious Model O-', 'Gaming Mouse', 'PMW 3360 Optical Sensor / 58grams', 2131165343, 49);");
        db.execSQL("INSERT INTO peripherals VALUES (4, 'Glorious Model D-', 'Gaming Mouse', 'PMW 3360 Optical Sensor / 68grams', 2131165341, 49);");
        db.execSQL("INSERT INTO peripherals VALUES (5, 'Glorious Model O Wireless', 'Gaming Mouse', 'BAMF 19000dpi Optical Sensor / 69grams', 2131165344, 79);");
        db.execSQL("INSERT INTO peripherals VALUES (6, 'HyperX Pulsefire Haste', 'Gaming Mouse', 'PMW 3335 Optical Sensor / 59grams', 2131165307, 49);");
        db.execSQL("INSERT INTO peripherals VALUES (7, 'HyperX Origins Core', 'Gaming Keyboard', 'Mechanical HyperX Red switches / RGB', 2131165367, 89);");
        db.execSQL("INSERT INTO peripherals VALUES (8, 'HyperX Cloud II', 'Gaming Headset', '53mm Drivers / 7.1 Surround / USB Sound Card', 2131165292, 99);");
        db.execSQL("INSERT INTO peripherals VALUES (9, 'SteelSeries Apex 7', 'Gaming Keyboard', 'Mechanical Switches/ RGB / Wristrest / Media Controls', 2131165278, 189);");
        db.execSQL("INSERT INTO peripherals VALUES (10, 'Logitech G Pro X Superlight', 'Gaming Mouse', 'HERO 25k Optical Sensor, 63grams', 2131165304, 199);");
        db.execSQL("INSERT INTO peripherals VALUES (11, 'LG 27GN950-B', 'Monitor', '27 Inch / Nano IPS / 3840 x 2160 / 144Hz', 2131165329, 1199);");
        db.execSQL("INSERT INTO peripherals VALUES (12, 'Gigabyte G27Q', 'Monitor', '27 Inch / IPS / 2560 x 1440 / 144Hz', 2131165303, 699);");
        db.execSQL("INSERT INTO peripherals VALUES (13, 'Aoc 24V2Q', 'Monitor', '24 Inch / IPS / 1920 x 1080 / 75Hz', 2131165277, 119);");


        db.execSQL("INSERT INTO laptops VALUES (1, 'Apple Macbook Air', 'Apple M1', 'Integrated', '1TB SSD', '16GB DDR4', '13 Inch 2650 x 1600', 2131165330, 999);");
        db.execSQL("INSERT INTO laptops VALUES (2, 'HP Envy X360', 'Ryzen 5 4500U', 'Integrated AMD Radeon Vega', '256GB nVME SSD', '8GB DDR4', '13 Inch 1920 x 1080', 2131165308, 749);");
        db.execSQL("INSERT INTO laptops VALUES (3, 'Apple Macbook Pro 13', 'Intel Core i5', 'Integrated Intel UHD', '512GB SSD', '16GB DDR4', '13.3 Inch 1680 x 1050', 2131165331, 1299);");
        db.execSQL("INSERT INTO laptops VALUES (4, 'Dell XPS 13', 'Intel i5 1135G7', 'Integrated Intel Xe', '256GB nVME SSD', '8GB DDR4', '13.4 Inch 1920 x 1200', 2131165294, 1099);");
        db.execSQL("INSERT INTO laptops VALUES (5, 'Asus Rog Zephyrus G14', 'Ryzen 9 4900HS', 'Nvidia RTX 2060 Max-Q', '1TB nVME SSD', '32GB DDR4', '14 Inch 2560 x 1440 120Hz', 2131165388, 1449);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS categories");
    }

    public Boolean insertUser(String username, String password, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        long result = db.insert("users", null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public ArrayList<Category> getCategories() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from categories", null);

        int count = cursor.getCount();

        ArrayList<Category> categories = new ArrayList<>();

        int i=0;
        while (cursor.moveToNext()){
            categories.add(new Category(cursor.getString(0), cursor.getInt(1)));
            i++;
        }

        cursor.close();
        db.close();
        return categories;
    }

    public ArrayList<Product> getProductsByCategory(String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from products where product_category =?", new String[] {category});

        int count = cursor.getCount();

        ArrayList<Product> products = new ArrayList<>();

        int i=0;
        while (cursor.moveToNext()){
            products.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4)));
            i++;
        }

        cursor.close();
        db.close();
        return products;
    }

    public ArrayList<Product> getAllProducts() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from products", null);

        int count = cursor.getCount();

        ArrayList<Product> products = new ArrayList<>();

        int i=0;
        while (cursor.moveToNext()){
            products.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4)));
            i++;
        }

        cursor.close();
        db.close();
        return products;
    }

    public PCComponent getComponentByName(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from components where component_name =?", new String[] {name});

        int count = cursor.getCount();

        PCComponent component = new PCComponent();

        while (cursor.moveToNext()){
            component = new PCComponent(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5));
        }

        cursor.close();
        db.close();
        return component;
    }

    public PCPeripheral getPeripheralByName(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from peripherals where peripheral_name =?", new String[] {name});

        int count = cursor.getCount();

        PCPeripheral peripheral = new PCPeripheral();

        while (cursor.moveToNext()){
            peripheral = new PCPeripheral(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5));
        }

        cursor.close();
        db.close();
        return peripheral;
    }

    public Laptop getLaptopByName(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from laptops where laptop_name =?", new String[] {name});

        int count = cursor.getCount();

        Laptop laptop = new Laptop();

        while (cursor.moveToNext()){
            laptop = new Laptop(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getInt(7), cursor.getInt(8));
        }

        cursor.close();
        db.close();
        return laptop;
    }

    public TV getTvByName(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from ТВ where tv_name =?", new String[] {name});

        int count = cursor.getCount();

        TV tv = new TV();

        while (cursor.moveToNext()){
            tv = new TV(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(7));
        }

        cursor.close();
        db.close();
        return tv;
    }

    public PCConfiguration getConfigurationByName(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from configurations where configuration_name =?", new String[] {name});

        int count = cursor.getCount();

        PCConfiguration configuration = new PCConfiguration();

        while (cursor.moveToNext()){
            configuration = new PCConfiguration(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getInt(9), cursor.getInt(10));
        }

        cursor.close();
        db.close();
        return configuration;
    }

    public MobilePhone getPhoneByName(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from phones where phone_name =?", new String[] {name});

        int count = cursor.getCount();

        MobilePhone phone = new MobilePhone();

        while (cursor.moveToNext()){
            phone = new MobilePhone(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getInt(8), cursor.getInt(9));
        }

        cursor.close();
        db.close();
        return phone;
    }

    public boolean addToCart(String item_name, int price, String username) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("item_name", item_name);
        contentValues.put("item_price", price);
        contentValues.put("user", username);

        long insert = db.insert("cartitems", null, contentValues);
        if (insert == -1)
            return false;
        else
            return true;
    }

    public ArrayList<CartItem> getMyItems(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from cartitems where user =?", new String [] {username});

        ArrayList<CartItem> myItems = new ArrayList<>();
        int i=0;
        while (cursor.moveToNext()){
            myItems.add(new CartItem(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
            //cities[i] = cursor.getString(1);
            i++;
        }
        cursor.close();
        db.close();
        return myItems;
    }

    public int getTotalPrice(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from cartitems where user =?", new String [] {username});

        ArrayList<CartItem> myItems = new ArrayList<>();
        int i = 0;
        int total = 0;
        while (cursor.moveToNext()){
            myItems.add(new CartItem(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
            total += cursor.getInt(2);
            i++;
        }
        cursor.close();
        db.close();
        return total;
    }

    public int getNumBought(String item) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from cartitems where item_name=? ", new String [] {item});
        int bought = cursor.getCount();

        cursor.close();
        db.close();
        return bought;
    }

    public void removeFromCart(String item_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "Delete from cartitems where cartitem_id = "+item_id;

        db.execSQL(query);
        db.close();
    }

    public String getEmail(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username = ?", new String[]{username});
        cursor.moveToNext();
        return cursor.getString(2);
    }
}
