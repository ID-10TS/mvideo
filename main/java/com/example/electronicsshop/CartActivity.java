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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.electronicsshop.models.CartItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    DbHelper db;
    RecyclerView mRecyclerView;
    adapterMyItems mAdapter;
    Button shopping;
    Button payment;
    String username;
    int totalprice;
    TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");
        db = new DbHelper(this);

        ArrayList<CartItem> myItems = new ArrayList<>();
        myItems = db.getMyItems(username);
        totalprice = db.getTotalPrice(username);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_my_items);
        shopping = (Button) findViewById(R.id.button_continue_shopping);
        payment = (Button) findViewById(R.id.button_payment);
        user = (TextView) findViewById(R.id.cart_welcome_name);

        user.setText(username);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new adapterMyItems(myItems, username, R.layout.my_item_row,this);
        mRecyclerView.setAdapter(mAdapter);

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalprice < 1) {
                    Toast.makeText(CartActivity.this, "Корзина пуста", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent  = new Intent(getApplicationContext(), BuyActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("totalprice", totalprice);
                    startActivity(intent);
                }
            }
        });

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.cart);
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