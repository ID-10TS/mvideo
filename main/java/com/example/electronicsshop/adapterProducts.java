package com.example.electronicsshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicsshop.models.Category;
import com.example.electronicsshop.models.Laptop;
import com.example.electronicsshop.models.Product;

import java.util.ArrayList;

public class adapterProducts extends RecyclerView.Adapter<adapterProducts.ViewHolder>{

    private ArrayList<Product> myList;
    private int rowLayout;
    private Context mContext;
    private String username;
    private DbHelper db;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productName;
        public TextView productQuantity;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.product_name);
            productQuantity = (TextView) itemView.findViewById(R.id.product_quantity);
        }
    }

    public adapterProducts(ArrayList<Product> products, int rowLayout, String username, Context context) {
        this.myList = products;
        this.rowLayout = rowLayout;
        this.username = username;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new adapterProducts.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        db = new DbHelper(mContext);
        Product entry = myList.get(position);
        holder.productName.setText(entry.getProductName());
        int available_quantity = entry.getProduct_quantity() - db.getNumBought(entry.getProductName());
        String available = String.valueOf(available_quantity) + " Доступно";
        holder.productQuantity.setText(available);
        if (entry.getProductCategory().equals("Мобильные телефоны")) {
            holder.productName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, PhoneActivity.class);
                    intent.putExtra("product", myList.get(position));
                    intent.putExtra("username", username);
                    mContext.startActivity(intent);
                }
            });
        }
        else if (entry.getProductCategory().equals("ТВ")) {
            holder.productName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, TvActivity.class);
                    intent.putExtra("product", myList.get(position));
                    intent.putExtra("username", username);
                    mContext.startActivity(intent);
                }
            });
        }
        else if (entry.getProductCategory().equals("Конфигурации ПК")) {
            holder.productName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ConfigurationActivity.class);
                    intent.putExtra("product", myList.get(position));
                    intent.putExtra("username", username);
                    mContext.startActivity(intent);
                }
            });
        }
        else if (entry.getProductCategory().equals("Компоненты ПК")) {
            holder.productName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ComponentActivity.class);
                    intent.putExtra("product", myList.get(position));
                    intent.putExtra("username", username);
                    mContext.startActivity(intent);
                }
            });
        }
        else if (entry.getProductCategory().equals("Переферия")) {
            holder.productName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, PeripheralActivity.class);
                    intent.putExtra("product", myList.get(position));
                    intent.putExtra("username", username);
                    mContext.startActivity(intent);
                }
            });
        }
        else {
            holder.productName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, LaptopActivity.class);
                    intent.putExtra("product", myList.get(position));
                    intent.putExtra("username", username);
                    mContext.startActivity(intent);
                }
            });
        }

        /*holder.productName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductsActivity.class);
                intent.putExtra("product", myList.get(position));
                intent.putExtra("username", username);
                mContext.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
}
