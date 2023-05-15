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

import com.example.electronicsshop.models.PCPeripheral;
import com.example.electronicsshop.models.Product;
import com.example.electronicsshop.models.TV;

public class PeripheralActivity extends AppCompatActivity {

    TextView peripheral_name;
    TextView peripheral_type;
    TextView peripheral_info;
    TextView peripheral_price;
    ImageView peripheral_photo;
    Button cart;

    String username;
    DbHelper db;
    Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peripheral);

        peripheral_name = (TextView) findViewById(R.id.peripheral_name_given);
        peripheral_type = (TextView) findViewById(R.id.peripheral_type_given);
        peripheral_info = (TextView) findViewById(R.id.peripheral_info_given);
        peripheral_price = (TextView) findViewById(R.id.peripheral_price_given);
        peripheral_photo = (ImageView) findViewById(R.id.peripheral_image);
        cart = (Button) findViewById(R.id.peripheral_button_cart);

        db = new DbHelper(this);
        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");
        product = incoming.getParcelableExtra("product");

        assert product != null;
        String product_name = product.getProductName();

        final PCPeripheral peripheral = db.getPeripheralByName(product_name);

        peripheral_name.setText(peripheral.getPeripheral_name());
        peripheral_type.setText(peripheral.getPeripheral_type());
        peripheral_info.setText(peripheral.getPeripheral_info());
        String price = "$" + String.valueOf(peripheral.getPeripheral_price());
        peripheral_price.setText(price);
        peripheral_photo.setImageResource(peripheral.getPeripheral_photo());

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product.getProduct_quantity() - db.getNumBought(product.getProductName()) < 1) {
                    Toast.makeText(PeripheralActivity.this, "В данный момент недоступно", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addToCart(peripheral.getPeripheral_name(), peripheral.getPeripheral_price(), username);
                    Toast.makeText(PeripheralActivity.this, "Добавлено в корзину", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(getApplicationContext(), CartActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });
    }
}