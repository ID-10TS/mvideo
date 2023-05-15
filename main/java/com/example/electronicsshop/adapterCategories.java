package com.example.electronicsshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.electronicsshop.models.Category;

import java.util.ArrayList;

public class adapterCategories extends RecyclerView.Adapter<adapterCategories.ViewHolder> {

    private ArrayList<Category> myList;
    private int rowLayout;
    private Context mContext;
    private String username;

    private int resId;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView categoryName;
        public ImageView categoryImage;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryName = (TextView) itemView.findViewById(R.id.category_name);
            categoryImage = (ImageView) itemView.findViewById(R.id.category_image);
        }
    }

    public adapterCategories(ArrayList<Category> categories, int rowLayout, String username, Context context) {
        this.myList = categories;
        this.rowLayout = rowLayout;
        this.username = username;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Category entry = myList.get(position);
        holder.categoryName.setText(entry.getName());
        holder.categoryImage.setImageResource(entry.getImage());
        holder.categoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductsActivity.class);
                //intent.putExtra("category", myList.get(position));
                intent.putExtra("category", entry.getName());
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
