package com.example.electronicsshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.electronicsshop.models.Laptop;
import com.example.electronicsshop.models.Product;

public class LaptopActivity extends AppCompatActivity {

    TextView laptop_name;
    TextView laptop_cpu;
    TextView laptop_gpu;
    TextView laptop_storage;
    TextView laptop_ram;
    TextView laptop_screen;
    TextView laptop_price;
    ImageView laptop_photo;
    Button cart;


    String username;
    DbHelper db;
    Product product;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);

        laptop_name = (TextView) findViewById(R.id.laptop_name_given);
        laptop_cpu = (TextView) findViewById(R.id.laptop_cpu_given);
        laptop_gpu = (TextView) findViewById(R.id.laptop_gpu_given);
        laptop_storage = (TextView) findViewById(R.id.laptop_storage_given);
        laptop_ram = (TextView) findViewById(R.id.laptop_ram_given);
        laptop_screen = (TextView) findViewById(R.id.laptop_screen_given);
        laptop_price = (TextView) findViewById(R.id.laptop_price_given);
        laptop_photo = (ImageView) findViewById(R.id.laptop_image);
        cart = (Button) findViewById(R.id.laptop_button_cart) ;

        db = new DbHelper(this);
        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");
        product = incoming.getParcelableExtra("product");

        assert product != null;
        String product_name = product.getProductName();

        final Laptop laptop = db.getLaptopByName(product_name);

        laptop_name.setText(laptop.getLaptop_name());
        laptop_cpu.setText(laptop.getLaptop_cpu());
        laptop_gpu.setText(String.valueOf(laptop.getLaptop_gpu()));
        laptop_storage.setText(laptop.getLaptop_storage());
        laptop_ram.setText(laptop.getLaptop_ram());
        laptop_screen.setText(laptop.getLaptop_screen());
        String price = "$" + String.valueOf(laptop.getLaptop_price());
        laptop_price.setText(price);
        laptop_photo.setImageResource(laptop.getLaptop_photo());

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product.getProduct_quantity() - db.getNumBought(product.getProductName()) < 1) {
                    Toast.makeText(LaptopActivity.this, "В данный момент недоступно", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addToCart(laptop.getLaptop_name(), laptop.getLaptop_price(), username);
                    Toast.makeText(LaptopActivity.this, "Добавлено в корзину", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(getApplicationContext(), CartActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });
    }
}