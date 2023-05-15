package com.example.electronicsshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.electronicsshop.models.PCComponent;
import com.example.electronicsshop.models.Product;

public class ComponentActivity extends AppCompatActivity {

    TextView component_name;
    TextView component_type;
    TextView component_info;
    TextView component_price;
    ImageView component_photo;
    Button cart;

    String username;
    DbHelper db;
    Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        component_name = (TextView) findViewById(R.id.component_name_given);
        component_type = (TextView) findViewById(R.id.component_type_given);
        component_info = (TextView) findViewById(R.id.component_info_given);
        component_price = (TextView) findViewById(R.id.component_price_given);
        component_photo = (ImageView) findViewById(R.id.component_image);
        cart = (Button) findViewById(R.id.component_button_cart);

        db = new DbHelper(this);
        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");
        product = incoming.getParcelableExtra("product");

        assert product != null;
        String product_name = product.getProductName();

        final PCComponent component = db.getComponentByName(product_name);

        component_name.setText(component.getComponent_name());
        component_type.setText(component.getComponent_type());
        component_info.setText(component.getComponent_info());
        String price = "$" + String.valueOf(component.getComponent_price());
        component_price.setText(price);
        component_photo.setImageResource(component.getComponent_photo());

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (product.getProduct_quantity() - db.getNumBought(product.getProductName()) < 1) {
                    Toast.makeText(ComponentActivity.this, "В данный момент недоступно", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addToCart(component.getComponent_name(), component.getComponent_price(), username);
                    Toast.makeText(ComponentActivity.this, "Добавлено в корзину", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(getApplicationContext(), CartActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });
    }
}