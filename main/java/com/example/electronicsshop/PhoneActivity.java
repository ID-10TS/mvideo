package com.example.electronicsshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.electronicsshop.models.MobilePhone;
import com.example.electronicsshop.models.Product;

public class PhoneActivity extends AppCompatActivity {

    TextView phone_name;
    TextView phone_os;
    TextView phone_screen;
    TextView phone_cpu;
    TextView phone_battery;
    TextView phone_camera;
    TextView phone_rear;
    TextView phone_price;
    ImageView phone_photo;
    Button cart;

    String username;
    DbHelper db;
    Product product;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        phone_name = (TextView) findViewById(R.id.phone_name_given);
        phone_os = (TextView) findViewById(R.id.phone_os_given);
        phone_screen = (TextView) findViewById(R.id.phone_screen_given);
        phone_cpu = (TextView) findViewById(R.id.phone_cpu_given);
        phone_battery = (TextView) findViewById(R.id.phone_battery_given);
        phone_camera = (TextView) findViewById(R.id.phone_camera_given);
        phone_rear = (TextView) findViewById(R.id.phone_selfie_given);
        phone_price = (TextView) findViewById(R.id.phone_price_given);
        phone_photo = (ImageView) findViewById(R.id.phone_image);
        cart = (Button) findViewById(R.id.phone_button_cart);

        db = new DbHelper(this);
        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");
        product = incoming.getParcelableExtra("product");

        assert product != null;
        String product_name = product.getProductName();

        final MobilePhone phone = db.getPhoneByName(product_name);

        phone_name.setText(phone.getPhone_name());
        phone_os.setText(phone.getPhone_os());
        phone_screen.setText(phone.getPhone_screen());
        phone_cpu.setText(phone.getPhone_cpu());
        phone_battery.setText(phone.getPhone_battery());
        phone_camera.setText(phone.getPhone_main_camera());
        phone_rear.setText(phone.getPhone_front_camera());
        String price = "$" + String.valueOf(phone.getPhone_price());
        phone_price.setText(price);
        phone_photo.setImageResource(phone.getPhone_photo());

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product.getProduct_quantity() - db.getNumBought(product.getProductName()) < 1) {
                    Toast.makeText(PhoneActivity.this, "В данный момент недоступно", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addToCart(phone.getPhone_name(), phone.getPhone_price(), username);
                    Toast.makeText(PhoneActivity.this, "Добавлено в корзину", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(getApplicationContext(), CartActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });

    }
}