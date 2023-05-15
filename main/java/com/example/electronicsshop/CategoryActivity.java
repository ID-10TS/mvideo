package com.example.electronicsshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.electronicsshop.R;
import com.example.electronicsshop.models.Category;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    adapterCategories mAdapter;
    DbHelper db;
    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        db = new DbHelper(this);
        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");

        ArrayList<Category> categories = new ArrayList<>();
        categories = db.getCategories();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_list);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new adapterCategories(categories, R.layout.category_row, username, this);

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
