package com.example.electronicsshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SaleActivity extends AppCompatActivity {

    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");

        setContentView(R.layout.activity_sale);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.sale);
        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.category:
                                startCategory();
                                break;

                            case R.id.home:
                                startHome();
                                break;

                            case R.id.cart:
                                startCart();
                                break;

                            case R.id.profile:
                                startProfile();
                                break;
                        }
                        return true;
                    }
                });
    }


    public final void startSale(){
        Intent intent = new Intent(this, SaleActivity.class);
        
        intent.putExtra("username", username);
        startActivity(intent);
    }

    public final void startCategory(){
        Intent intent = new Intent(this, CategoryActivity.class);
        
        intent.putExtra("username", username);
        startActivity(intent);
    }
    public final void startHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        
        intent.putExtra("username", username);
        startActivity(intent);
    }
    public final void startCart(){
        Intent intent = new Intent(this, CartActivity.class);
        
        intent.putExtra("username", username);
        startActivity(intent);
    }
    public final void startProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        
        intent.putExtra("username", username);
        startActivity(intent);
    }
}