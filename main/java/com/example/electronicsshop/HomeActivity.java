package com.example.electronicsshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.electronicsshop.models.Category;
import com.example.electronicsshop.models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    adapterProducts mAdapter;
    DbHelper db;
    String username;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        db = new DbHelper(this);
        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");

        db = new DbHelper(this);
        Intent intent = getIntent();

        ArrayList<Product> products = new ArrayList<>();
        products = db.getAllProducts();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new adapterProducts(products, R.layout.product_row, username, this);
        mRecyclerView.setAdapter(mAdapter);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.home);

        navigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.sale:
                                startSale();
                                break;

                            case R.id.category:
                                startCategory();
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