package com.example.electronicsshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BuyActivity extends AppCompatActivity {

    String username;
    int totalprice;
    Button pay;
    TextView user;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        Intent incoming = getIntent();
        username = incoming.getStringExtra("username");
        totalprice = incoming.getIntExtra("totalprice", 0);
        String total = "$" + String.valueOf(totalprice);

        pay = (Button) findViewById(R.id.button_pay);
        user = (TextView) findViewById(R.id.buy_welcome_name);
        price = (TextView) findViewById(R.id.buy_price_number);

        user.setText(username);
        price.setText(total);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuyActivity.this, "Спасибо за доверие!", Toast.LENGTH_SHORT).show();
                startHome();
            }
        });
    }
    public final void startHome(){
        Intent intent = new Intent(this, HomeActivity.class);

        intent.putExtra("username", username);
        startActivity(intent);
    }
}