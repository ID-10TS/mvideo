package com.example.electronicsshop;

import android.content.Context;
import android.content.Intent;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicsshop.models.CartItem;

import java.util.ArrayList;

public class adapterMyItems extends RecyclerView.Adapter<adapterMyItems.ViewHolder> {
    private ArrayList<CartItem> myList;
    private String username;
    private int rowLayout;
    private Context mContext;
    private DbHelper db;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView price;
        public Button remove;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.my_item_name);
            price = (TextView) itemView.findViewById(R.id.my_item_price);
            remove = (Button) itemView.findViewById(R.id.button_remove_item);
        }
    }

    public adapterMyItems(ArrayList<CartItem> items, String username, int rowLayout, Context context) {
        this.myList = items;
        this.username = username;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        db = new DbHelper(mContext);
        final CartItem item = myList.get(position);

        holder.name.setText(item.getCartitem_name());
        String price = "$" + String.valueOf(item.getCartitem_price());
        holder.price.setText(price);

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.removeFromCart(String.valueOf(item.getCartitem_id()));
                Toast.makeText(mContext, "Удалить из корзины", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, CartActivity.class);
                intent.putExtra("username", username);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }
}
