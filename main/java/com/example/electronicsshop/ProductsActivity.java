package com.example.electronicsshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.electronicsshop.models.Category;
import com.example.electronicsshop.models.Product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    adapterProducts mAdapter;
    DbHelper db;
    String username;
    String category_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        db = new DbHelper(this);
        Intent intent = getIntent();
        //final Category category  = intent.getParcelableExtra("category");

        username = intent.getStringExtra("username");
        category_name = intent.getStringExtra("category");

        ArrayList<Product> products = new ArrayList<>();
        products = db.getProductsByCategory(category_name);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_product_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new adapterProducts(products, R.layout.product_row, username, this);
        mRecyclerView.setAdapter(mAdapter);


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.category);
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